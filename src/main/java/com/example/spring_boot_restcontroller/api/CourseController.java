package com.example.spring_boot_restcontroller.api;

import com.example.spring_boot_restcontroller.dto.request.CourseRequest;
import com.example.spring_boot_restcontroller.dto.response.CourseResponse;
import com.example.spring_boot_restcontroller.dto.response.GroupResponse;
import com.example.spring_boot_restcontroller.dto.response.InstructorResponse;
import com.example.spring_boot_restcontroller.service.CourseService;
import com.example.spring_boot_restcontroller.service.GroupService;
import com.example.spring_boot_restcontroller.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;
    private  final GroupService groupService;
    private final InstructorService instructorService;

    @GetMapping("/getAllCourse")
    public List<CourseResponse> getAllCourse() {
        return courseService.getAllCourse();
    }

    @GetMapping("/getAllCourseByCompanyId/{companyId}")
    public List<CourseResponse> getAllCourseByCompanyId(@PathVariable Long companyId) {
        return courseService.getAllCourse(companyId);
    }

    @GetMapping("/getCourseById/{id}")
    public CourseResponse getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    @PostMapping("/{companyId}/saveCourse")
    public CourseResponse saveCourse(@PathVariable Long companyId, @RequestBody CourseRequest courseRequest) throws IOException {
        return courseService.saveCourse(companyId, courseRequest);
    }

    @PutMapping("/updateCourse/{id}")
    public CourseResponse updateCourse(@PathVariable Long id, @RequestBody CourseRequest courseRequest) {
        return courseService.updateCourse(id, courseRequest);
    }

    @DeleteMapping("/deleteCourseById/{id}")
    public CourseResponse deleteCourseById(@PathVariable Long id) {
        return courseService.deleteCourse(id);
    }

    @PostMapping("/assignGroupToCourse/{courseId}/{id}")
    private GroupResponse assignGroupToCourse(@PathVariable Long courseId,
                                              @PathVariable Long id) throws IOException {
        return groupService.assignGroup(courseId, id);
    }

    @PostMapping("/assignInstructor/{id}/{courseId}")
    private InstructorResponse assignInstructorToCourse(@PathVariable Long id,
                                                        @PathVariable Long courseId) throws IOException {
        return instructorService.assignInstructor(id, courseId);
    }
}
