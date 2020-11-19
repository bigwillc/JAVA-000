package com.example.homeworkWeek5.module;


import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.Serializable;


@Data
@ToString
@Component
@Slf4j
public class Student implements Serializable {
    
    private int id;
    private String name;

    public Student() {
       log.info("I am a student!");
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public void init(){
        System.out.println("hello...........");
    }
    
    public Student create(){
        return new Student(101,"KK101");
    }
}
