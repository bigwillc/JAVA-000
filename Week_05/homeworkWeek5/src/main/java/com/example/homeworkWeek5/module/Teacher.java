package com.example.homeworkWeek5.module;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Teacher {
    private String name;

    public Teacher() {
        log.info("I am a teacher");
    }

    public Teacher(String name) {
        log.info("I am a teacher, my name is {}", name);
    }
}
