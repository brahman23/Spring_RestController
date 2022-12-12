package com.example.spring_boot_restcontroller.repository;

import com.example.spring_boot_restcontroller.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
}