package com.example.spring_boot_restcontroller.service;

import com.example.spring_boot_restcontroller.dto.request.InstructorRequest;
import com.example.spring_boot_restcontroller.dto.response.InstructorResponse;

import java.io.IOException;
import java.util.List;

public interface InstructorService {

    List<InstructorResponse> getAllInstructor();
    List<InstructorResponse> getAllInstructors(Long courseId);
    InstructorResponse getInstructorById(Long id);
    InstructorResponse saveInstructor(Long courseId, InstructorRequest instructorRequest) throws IOException;
    InstructorResponse updateInstructor(Long id, InstructorRequest instructorRequest) throws IOException;
    InstructorResponse deleteInstructor(Long id);
    InstructorResponse assignInstructor(Long id, Long courseId) throws IOException;
}
