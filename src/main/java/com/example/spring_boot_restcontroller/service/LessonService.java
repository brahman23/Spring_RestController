package com.example.spring_boot_restcontroller.service;

import com.example.spring_boot_restcontroller.dto.request.LessonRequest;
import com.example.spring_boot_restcontroller.dto.response.LessonResponse;

import java.util.List;

public interface LessonService {

    List<LessonResponse> getAllLesson();

    List<LessonResponse> getAllLesson(Long courseId);

    LessonResponse getLessonById(Long id);

    LessonResponse saveLesson(Long courseId, LessonRequest lessonRequest);

    LessonResponse updateLesson(Long id, LessonRequest lessonRequest);

    LessonResponse deleteLesson(Long id);
}
