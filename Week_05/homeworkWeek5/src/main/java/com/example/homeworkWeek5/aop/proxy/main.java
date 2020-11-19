package com.example.homeworkWeek5.aop.proxy;

import com.example.homeworkWeek5.aop.proxy.impl.BussinessServiceImpl;
import com.example.homeworkWeek5.aop.proxy.service.BussinessService;

import java.lang.reflect.Proxy;

public class main {
    public static void main(String[] args) {
        final BussinessServiceImpl bussinessService = new BussinessServiceImpl();
        final BussinessService bService = (BussinessService)Proxy.newProxyInstance(
                LogInvokeHandler.class.getClassLoader(),
                bussinessService.getClass().getInterfaces(),
                new LogInvokeHandler(bussinessService));
        bService.find();
        bussinessService.find();
        bService.login("userName", "123456");
        bussinessService.login("userName", "*****");
    }
}
