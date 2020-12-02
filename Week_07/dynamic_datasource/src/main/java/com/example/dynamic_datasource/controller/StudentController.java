package com.example.dynamic_datasource.controller;


import com.example.dynamic_datasource.entity.Student;
import com.example.dynamic_datasource.mapper.StudentMapper;
import com.example.dynamic_datasource.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/student/getAll")
    public List<Student> getAllStudentInfo() {
        return studentService.getAll();
    }

    public void getStudentById() {

    }

    @GetMapping("/student/addStudent")
    public void addStudent() {
        Student student = new Student();
        student.setId(5);
        student.setName("li");
        student.setEmail("hello@apache.com");
        studentService.add(student);
    }

    public void deleteStudent() {

    }
}
