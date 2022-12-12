package com.example.spring_boot_restcontroller.converter.instructor;

import com.example.spring_boot_restcontroller.dto.response.InstructorResponse;
import com.example.spring_boot_restcontroller.entity.Instructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InstructorConverterResponse {

    public InstructorResponse create(Instructor instructor) {
        if (instructor == null) return null;
        InstructorResponse instructorResponse = new InstructorResponse();
        instructorResponse.setId(instructor.getId());
        instructorResponse.setFirstName(instructor.getFirstname());
        instructorResponse.setLastName(instructor.getLastname());
        instructorResponse.setPhoneNumber(instructor.getPhoneNumber());
        instructorResponse.setEmail(instructor.getEmail());
        instructorResponse.setSpecialization(instructor.getSpecialization());
//        instructorResponse.setStudent(instructor.getStudent());
        return instructorResponse;
    }

    public List<InstructorResponse> getAll(List<Instructor> instructors) {
        List<InstructorResponse> instructorResponses = new ArrayList<>();
        for (Instructor i : instructors) {
            instructorResponses.add(create(i));
        }
        return instructorResponses;
    }
}
