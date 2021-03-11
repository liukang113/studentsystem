package com.interviewed.design_mode.agency.dynamic2.cglib;

import com.interviewed.design_mode.agency.dynamic2.CglibTestSon;

import java.lang.reflect.Method;

/**
 * @author: kang.liu
 * @since : 2019/3/10 6:07 PM
 */

/**
 * 可以类比于jdk动态代理中的InvocationHandler ，实际上被代理后重要的类，实际上后续执行的就是intercept里的方法，
 * 如果需要执行原来的方法，则调用 method.invoke(s, args);
 * 这里也加了一个aopMethod();
 */
public class MethdInvoker/* implements MethodInterceptor*/ {
    private CglibTestSon cglibTestSon;

    /**
     * 被代理后执行的是intercept方法
     * @param o
     * @param method
     * @param objects
     * @param methodProxy
     * @return
     * @throws Throwable
     */
  /*  @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        aopMethod();
        Object a = method.invoke(cglibTestSon, objects);
        return a;
    }*/

    public MethdInvoker(CglibTestSon cglibTestSon) {
        this.cglibTestSon = cglibTestSon;
    }

    private void aopMethod() {
        System.out.println("i am aopMethod");
    }
}
