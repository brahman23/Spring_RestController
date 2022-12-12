package com.example.spring_boot_restcontroller.converter.instructor;

import com.example.spring_boot_restcontroller.dto.request.InstructorRequest;
import com.example.spring_boot_restcontroller.entity.Instructor;
import org.springframework.stereotype.Component;

@Component
public class InstructorConverterRequest {

    public Instructor create(InstructorRequest instructorRequest) {
        if (instructorRequest == null) return null;
        Instructor instructor = new Instructor();
        instructor.setFirstname(instructorRequest.getFirstName());
        instructor.setLastname(instructorRequest.getLastName());
        instructor.setEmail(instructorRequest.getEmail());
        instructor.setPhoneNumber(instructorRequest.getPhoneNumber());
        instructor.setSpecialization(instructorRequest.getSpecialization());
        return instructor;
    }

    public void update(Instructor instructor, InstructorRequest instructorRequest) {
        if (instructorRequest.getFirstName() != null) {
            instructor.setFirstname(instructorRequest.getFirstName());
        }
        if (instructorRequest.getLastName() != null) {
            instructor.setLastname(instructorRequest.getLastName());
        }
        if (instructorRequest.getPhoneNumber() != null) {
            instructor.setPhoneNumber(instructorRequest.getPhoneNumber());
        }
        if (instructorRequest.getEmail() != null) {
            instructor.setEmail(instructorRequest.getEmail());
        }
        if (instructorRequest.getSpecialization() != null) {
            instructor.setSpecialization(instructorRequest.getSpecialization());
        }
    }
}
