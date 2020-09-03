package com.enricobottani.securityamigoscode.repository;

import com.enricobottani.securityamigoscode.model.Student;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class StudentRepository {
    private static final List<Student> STUDENT_LIST = Arrays.asList(
            new Student(1, "James Bond"),
            new Student(2, "Maria Jones"),
            new Student(3, "Anna Smith")
    );

    public List<Student> getAllStudents() {
        return STUDENT_LIST;
    }

    public Student getStudentById(int id) {
        return STUDENT_LIST.stream().filter(student -> student.getStudentId() == id)
                .findFirst().orElseThrow(() -> new IllegalStateException("Student " + id + " does not exists"));
    }
}
