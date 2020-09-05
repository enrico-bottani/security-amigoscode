package com.enricobottani.securityamigoscode.controller;

import com.enricobottani.securityamigoscode.model.Student;
import com.enricobottani.securityamigoscode.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {

    @Autowired
    StudentRepository studentRepository;

    // CREATE READ UPDATE DELETE

    @PostMapping
    public void createStudent(@RequestBody Student student) {
        System.out.println("createStudent: " + student);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") Integer studentId, @RequestBody Student student) {
        System.out.println(String.format("updateStudent: id: %s %s", studentId, student));
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Integer id) {
        System.out.println("deleteStudent: " + id);
    }
}
