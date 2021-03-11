package com.interviewed.design_mode.agency.dynamic;

import com.interviewed.design_mode.agency.UserService;
import com.interviewed.design_mode.agency.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: kang.liu
 * Date  : 2019/1/28 19:37
 * Description: JDK动态代理
 */
public class MyInvocationHandler implements InvocationHandler {
    private Object target;

    MyInvocationHandler() {
        super();
    }

    MyInvocationHandler(Object target) {
        super();
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if ("getName".equals(method.getName())) {
            System.out.println("++++++before " + method.getName() + "++++++");
            Object invoke = method.invoke(target, args);
            System.out.println("++++++after " + method.getName() + "++++++");
            return invoke;
        } else {
            Object result = method.invoke(target, args);
            return result;
        }
    }

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        InvocationHandler invocationHandler = new MyInvocationHandler(userService);
        // 实现代理
        UserService userServiceProxy = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(),
                userService.getClass().getInterfaces(), invocationHandler);
        System.out.println(userServiceProxy.getName(1, "LK"));
        System.out.print(userServiceProxy.getAge(1));
    }
}