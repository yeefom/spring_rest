package com.yeefom.rest.server;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.yeefom.rest.entity.Student;
import com.yeefom.rest.entity.StudentNotFoundException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StudentController {

    private List<Student> students = new ArrayList<>();

    @PostConstruct
    public void createData() {
        students.add(new Student("Alex", "Ham"));
        students.add(new Student("Aaron", "Burr"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/student/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        if (studentId < 0 || studentId >= students.size()) {
            throw new StudentNotFoundException("student id not found: " + studentId);
        }

        return students.get(studentId);
    }

}
