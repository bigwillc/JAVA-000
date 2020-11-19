package com.example.homeworkWeek5.aop.cglib;

import com.example.homeworkWeek5.aop.proxy.impl.BussinessServiceImpl;
import org.springframework.cglib.proxy.Enhancer;

public class Main {
    public static void main(String[] args) {
        MyHandler myHandler = new MyHandler();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(BussinessServiceImpl.class);
        enhancer.setCallback(myHandler);

        BussinessServiceImpl bussinessService = (BussinessServiceImpl) enhancer.create();
        bussinessService.find();
    }
}
