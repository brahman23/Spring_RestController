package com.example.spring_boot_restcontroller.api;

import com.example.spring_boot_restcontroller.dto.request.InstructorRequest;
import com.example.spring_boot_restcontroller.dto.response.InstructorResponse;
import com.example.spring_boot_restcontroller.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/instructors")
public class InstructorController {
    private final InstructorService instructorService;

    @GetMapping("/getAllInstructor")
    public List<InstructorResponse> getAllCourse() {
        return instructorService.getAllInstructor();
    }

    @GetMapping("/getInstructorByIdCourseId/{courseId}")
    public List<InstructorResponse> getInstructorByIdCourseId(@PathVariable Long courseId){
        return instructorService.getAllInstructors(courseId);
    }

    @GetMapping("/getInstructorById/{id}")
    public InstructorResponse getInstructorById(@PathVariable Long id) {
        return instructorService.getInstructorById(id);
    }

    @PostMapping("/saveInstructor/{courseId}")
    public InstructorResponse saveInstructor(@PathVariable Long courseId,
                                             @RequestBody InstructorRequest instructorRequest)throws IOException{
    return instructorService.saveInstructor(courseId,instructorRequest);
    }

    @PutMapping("/updateInstructor/{id}")
    public InstructorResponse updateInstructor(@PathVariable Long id,@RequestBody InstructorRequest instructorRequest) throws IOException{
        return instructorService.updateInstructor(id, instructorRequest);
    }

    @DeleteMapping("/deleteInstructorById/{id}")
    public InstructorResponse deleteInstructorById(@PathVariable Long id){
        return instructorService.deleteInstructor(id);
    }



}
