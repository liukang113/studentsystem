package com.interviewed.design_mode.agency.dynamic;

import com.interviewed.design_mode.agency.UserService;
import com.interviewed.design_mode.agency.UserServiceImpl;


import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * Author: kang.liu
 * Date  : 2019/1/28 20:26
 * Description:
 * <>
 * 优点：可以做到不对目标对象进行修改的前提下，对目标对象进行功能的扩展和拦截。
 * <p>
 * 缺点：因为代理对象，需要实现与目标对象一样的接口，会导致代理类十分繁多，不易维护，同时一旦接口增加方法，则目标对象和代理类都需要维护。
 * </>
 *
 * <>
 *
 * </>
 */
public class CglibProxy /*implements MethodInterceptor*/ {

//    @Override
//    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
//        System.out.println("++++++before " + methodProxy.getSuperName() + "++++++");
//        System.out.println(method.getName());
//        Object o1 = methodProxy.invokeSuper(o, args);
//        System.out.println("++++++before " + methodProxy.getSuperName() + "++++++");
//        return o1;
//    }
//
//    public static void main(String[] args) {
//        CglibProxy cglibProxy = new CglibProxy();
//        // 主要的增强类
//        Enhancer enhancer = new Enhancer();
//        enhancer.setSuperclass(UserServiceImpl.class);
//        enhancer.setCallback(cglibProxy);
//
//        UserService o = (UserService) enhancer.create();
//        o.getName(1);
//        o.getAge(1);
//    }
}