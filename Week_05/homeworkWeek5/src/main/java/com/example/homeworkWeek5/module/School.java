package com.example.homeworkWeek5.module;

import com.example.homeworkWeek5.aop.ISchool;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

@Data
@Slf4j
public class School implements ISchool {
    // Resource
    @Autowired(required = true) //primary
            Klass class1;

    //@Resource(name = "student100")
    @Resource
    Student student100;

    public School() {
        log.info("Initializing School.");
    }

    @Override
    public void ding(){

        //System.out.println("Class1 have " + this.class1.getStudents().size() + " students and one is " + this.student100);
        log.info("Class1 have " + this.class1.getStudents().size() + " students and one is " + this.student100);
    }
}
