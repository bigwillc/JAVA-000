package com.example.homeworkWeek5.aop.proxy.impl;

import com.example.homeworkWeek5.aop.proxy.service.BussinessService;

import java.util.logging.Logger;

public class BussinessServiceImpl implements BussinessService {
    private Logger logger = Logger.getLogger(this.getClass().getSimpleName());
    @Override
    public void login(String username, String password) {
        System.out.println("login success!");
    }

    @Override
    public void find() {
        System.out.println("find success!");
    }
}
