package com.example.spring_boot_restcontroller.api;

import com.example.spring_boot_restcontroller.dto.request.StudentRequest;
import com.example.spring_boot_restcontroller.dto.response.StudentResponse;
import com.example.spring_boot_restcontroller.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/getAllStudent")
    public List<StudentResponse> getAllStudent() {
        return studentService.getAllStudent();
    }

    @GetMapping("/getAllStudentByGroupId/{groupId}")
    public List<StudentResponse> getAllStudentByCourseId(@PathVariable Long groupId) {
        return studentService.getAllStudent(groupId);
    }

    @GetMapping("/getStudentById/{id}")
    public StudentResponse getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping("/saveStudent/{groupId}")
    public StudentResponse saveStudent(@PathVariable Long groupId, @RequestBody StudentRequest studentRequest) throws IOException {
        return studentService.saveStudent(groupId, studentRequest);
    }

    @PutMapping("/updateStudent/{id}")
    public StudentResponse saveUpdateStudent(@PathVariable Long id,
                                             @RequestBody StudentRequest studentRequest) throws IOException {
        return studentService.updateStudent(id, studentRequest);
    }

    @DeleteMapping("/deleteStudentById/{id}")
    public StudentResponse deleteStudentById(@PathVariable Long id) {
        return studentService.deleteStudent(id);
    }
}
