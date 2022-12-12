package com.example.spring_boot_restcontroller.converter.lesson;

import com.example.spring_boot_restcontroller.dto.request.InstructorRequest;
import com.example.spring_boot_restcontroller.dto.request.LessonRequest;
import com.example.spring_boot_restcontroller.entity.Instructor;
import com.example.spring_boot_restcontroller.entity.Lesson;
import org.springframework.stereotype.Component;

@Component
public class LessonConverterRequest {

    public Lesson create(LessonRequest lessonRequest) {
        if (lessonRequest == null) return null;
        Lesson lesson = new Lesson();
        lesson.setLessonName(lessonRequest.getLessonName());
        return lesson;
    }

    public void update(Lesson lesson, LessonRequest lessonRequest) {
        if (lessonRequest.getLessonName() != null) {
            lesson.setLessonName(lessonRequest.getLessonName());
        }
    }
}
