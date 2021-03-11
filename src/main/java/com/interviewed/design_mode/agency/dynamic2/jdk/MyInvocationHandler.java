package com.interviewed.design_mode.agency.dynamic2.jdk;

import com.interviewed.design_mode.agency.dynamic2.JavaProxyInterface;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: kang.liu
 * @since : 2019/3/10 6:07 PM
 */
public class MyInvocationHandler implements InvocationHandler {
    JavaProxyInterface javaProxy;

    public MyInvocationHandler(JavaProxyInterface javaProxy) {
        this.javaProxy = javaProxy;
    }

    private void aopMethod() {
        System.out.println("before proxy method execute...");
    }
    //继承方法，代理时实际执行的方法，如果要实现原方法，则需要调用method.invoke(javaProxy, args)，这里还调用了一个aopMethod(),可以类比于Spring中的切面before注解。

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        aopMethod();
        return method.invoke(javaProxy, args);
    }
}
