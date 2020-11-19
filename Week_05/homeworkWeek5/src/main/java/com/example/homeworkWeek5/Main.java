package com.example.homeworkWeek5;

import com.example.homeworkWeek5.module.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext();
        Student student123 = (Student) context.getBean("123");
        System.out.println(student123.toString());
    }
}
