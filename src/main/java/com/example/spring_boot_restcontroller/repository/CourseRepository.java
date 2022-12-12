package com.example.spring_boot_restcontroller.repository;

import com.example.spring_boot_restcontroller.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}