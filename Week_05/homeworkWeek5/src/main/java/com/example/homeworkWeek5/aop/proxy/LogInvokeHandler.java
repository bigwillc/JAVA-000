package com.example.homeworkWeek5.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.logging.Logger;

public class LogInvokeHandler implements InvocationHandler {
    private Logger logger = Logger.getLogger(this.getClass().getSimpleName());

    private final Object target;

    public LogInvokeHandler(Object target) {
        this.target = target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("-----------before-------------");
        final Object o = method.invoke(this.target, args);
        System.out.println("-----------after--------------");
        return o;
    }

}
