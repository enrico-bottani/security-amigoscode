package com.enricobottani.securityamigoscode.controller;

import com.enricobottani.securityamigoscode.debug.DebugUtils;
import com.enricobottani.securityamigoscode.model.Student;
import com.enricobottani.securityamigoscode.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("management/api/v1/students")
@Slf4j
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
        log.info(String.format(
                "Called [%s] - User [%s], auth [%s]",
                DebugUtils.getCurrentMethodName(),
                ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername(),
                ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getAuthorities()
        ));
        return studentRepository.getAllStudents();
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") Integer studentId, @RequestBody Student student) {
        log.info(String.format("updateStudent: id: %s %s", studentId, student));
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Integer id) {
        System.out.println("deleteStudent: " + id);
    }
}
