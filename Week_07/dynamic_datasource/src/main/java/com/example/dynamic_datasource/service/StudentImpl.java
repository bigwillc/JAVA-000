package com.example.dynamic_datasource.service;

import com.example.dynamic_datasource.entity.Student;
import com.example.dynamic_datasource.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;

    @Override
    public int add(Student student) {
        return studentMapper.save(student);
    }

    @Override
    public List<Student> getAll() {
        return studentMapper.selectAll();
    }
}
