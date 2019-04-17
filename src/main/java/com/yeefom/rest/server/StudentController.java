package com.yeefom.rest.server;

import java.util.ArrayList;
import java.util.List;

import com.yeefom.rest.entity.Student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StudentController {

    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alex", "Ham"));
        students.add(new Student("Aaron", "Burr"));

        return students;
    }

}
