package com.interviewed.design_mode.agency.dynamic2;

/**
 * @author: kang.liu
 * @since : 2019/3/10 6:07 PM
 */

// 需要被代理的类
public class CglibTestSon {
    public CglibTestSon() {
    }
    public void gotoHome() {
        System.out.println("============gotoHome============");
    }
    public void gotoSchool() {
        System.out.println("===========gotoSchool============");
    }
    public void oneday() {
        gotoHome();
        gotoSchool();
    }
    public final void onedayFinal() {
        gotoHome();
        gotoSchool();
    }
}
