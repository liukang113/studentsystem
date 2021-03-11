package com.interviewed.design_mode.agency.static_state;

/**
 * Created with IntelliJ IDEA.
 * Author: kang.liu
 * Date  : 2019/1/29 10:45
 * Description:
 * <>
 * 静态代理：
 * 1.实现目标代理对象的接口
 * 2.维护一个代理对象，通过构造器传入实际对象并赋值
 * 3.执行代理对象实现的接口方法，实现对目标对象的操作干预
 * </>
 */
public class BussinessInterfaceProxy implements BussinessInterface {

    private BussinessInterface bussinessInterfaceImpl;

    public BussinessInterfaceProxy(BussinessInterface bussinessInterfaceImpl) {
        this.bussinessInterfaceImpl = bussinessInterfaceImpl;
    }

    @Override
    public void execute() {
        System.out.println("前拦截...");
        bussinessInterfaceImpl.execute();
        System.out.println("后拦截...");
    }
}