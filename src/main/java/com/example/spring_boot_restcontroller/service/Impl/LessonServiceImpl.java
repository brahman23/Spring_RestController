package com.example.spring_boot_restcontroller.service.Impl;

import com.example.spring_boot_restcontroller.converter.lesson.LessonConverterRequest;
import com.example.spring_boot_restcontroller.converter.lesson.LessonConverterResponse;
import com.example.spring_boot_restcontroller.dto.request.LessonRequest;
import com.example.spring_boot_restcontroller.dto.response.LessonResponse;
import com.example.spring_boot_restcontroller.entity.Course;
import com.example.spring_boot_restcontroller.entity.Lesson;
import com.example.spring_boot_restcontroller.repository.CourseRepository;
import com.example.spring_boot_restcontroller.repository.LessonRepository;
import com.example.spring_boot_restcontroller.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {
    private final CourseRepository courseRepository;
    private final LessonRepository lessonRepository;
    private final LessonConverterRequest lessonConverterRequest;
    private final LessonConverterResponse lessonConverterResponse;

    @Override
    public List<LessonResponse> getAllLesson() {
        return lessonConverterResponse.getAll(lessonRepository.findAll());
    }

    @Override
    public List<LessonResponse> getAllLesson(Long courseId) {
        Course course = courseRepository.findById(courseId).get();
        return lessonConverterResponse.getAll(course.getLessons());
    }

    @Override
    public LessonResponse getLessonById(Long id) {
        return lessonConverterResponse.create(lessonRepository.findById(id).get());
    }

    @Override
    public LessonResponse saveLesson(Long courseId, LessonRequest lessonRequest) {
        Course course = courseRepository.findById(courseId).get();
        Lesson lesson = lessonConverterRequest.create(lessonRequest);
        course.addLesson(lesson);
        lesson.setCourse(course);
        lessonRepository.save(lesson);
        return lessonConverterResponse.create(lesson);
    }

    @Override
    public LessonResponse updateLesson(Long id, LessonRequest lessonRequest) {
        Lesson lesson = lessonRepository.findById(id).get();
        lessonConverterRequest.update(lesson, lessonRequest);
        return lessonConverterResponse.create(lessonRepository.save(lesson));
    }

    @Override
    public LessonResponse deleteLesson(Long id) {
        Lesson lesson = lessonRepository.findById(id).get();
        lessonRepository.delete(lesson);
        return lessonConverterResponse.create(lesson);
    }
}
