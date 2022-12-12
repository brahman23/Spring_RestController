package com.example.spring_boot_restcontroller.converter.course;

import com.example.spring_boot_restcontroller.dto.request.CourseRequest;
import com.example.spring_boot_restcontroller.entity.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseConverterRequest {
    public Course create(CourseRequest courseRequest) {
        if (courseRequest == null) return null;
        Course course = new Course();
        course.setCourseName(courseRequest.getCourseName());
        course.setDuration(courseRequest.getDuration());
        course.setDescription(courseRequest.getDescription());
        return course;
    }

    public void update(Course course, CourseRequest courseRequest) {
        course.setCourseName(courseRequest.getCourseName());
        course.setDuration(courseRequest.getDuration());
        course.setDescription(courseRequest.getDescription());
    }
}
