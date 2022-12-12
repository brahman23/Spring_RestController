package com.example.spring_boot_restcontroller.repository;

import com.example.spring_boot_restcontroller.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {
}