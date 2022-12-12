package com.example.spring_boot_restcontroller.api;

import com.example.spring_boot_restcontroller.dto.request.LessonRequest;
import com.example.spring_boot_restcontroller.dto.response.LessonResponse;
import com.example.spring_boot_restcontroller.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lessons")
public class LessonController {

    private final LessonService lessonService;

    @GetMapping("/getAllLesson")
    public List<LessonResponse> getAllLesson() {
        return lessonService.getAllLesson();
    }

    @GetMapping("/getAllLessonByCourseId/{courseId}")
    public List<LessonResponse> getAllInstructorByCourseId(@PathVariable Long courseId) {
        return lessonService.getAllLesson(courseId);
    }

    @GetMapping("/getLessonById/{id}")
    public LessonResponse getLessonById(@PathVariable Long id) {
        return lessonService.getLessonById(id);
    }

    @PostMapping("/saveLesson/{courseId}")
    public LessonResponse saveLesson(@PathVariable Long courseId, @RequestBody LessonRequest lessonRequest) {
        return lessonService.saveLesson(courseId, lessonRequest);
    }

    @PutMapping("/updateLesson/{id}")
    public LessonResponse updateLesson(@PathVariable Long id, @RequestBody LessonRequest lessonRequest) {
        return lessonService.updateLesson(id, lessonRequest);
    }

    @DeleteMapping("/deleteLessonById/{id}")
    public LessonResponse deleteLessonById(@PathVariable Long id) {
        return lessonService.deleteLesson(id);
    }
}
