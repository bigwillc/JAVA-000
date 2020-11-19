package com.example.homeworkWeek5;

import com.example.homeworkWeek5.module.School;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@Slf4j
public class MyAutoConfiguration {
    @Bean
    public School school() {
        School school = new School();
        //school.ding();
        return school;
    }
}
