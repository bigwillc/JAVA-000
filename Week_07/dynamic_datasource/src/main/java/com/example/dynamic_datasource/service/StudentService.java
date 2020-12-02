package com.example.dynamic_datasource.service;

import com.example.dynamic_datasource.entity.Student;

import java.util.List;

public interface StudentService {

    int add(Student student);

    List<Student> getAll();


}
