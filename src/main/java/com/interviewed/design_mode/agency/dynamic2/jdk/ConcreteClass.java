package com.interviewed.design_mode.agency.dynamic2.jdk;

import com.interviewed.design_mode.agency.dynamic2.JavaProxyInterface;

/**
 * @author: kang.liu
 * @since : 2019/3/10 6:07 PM
 */
public class ConcreteClass implements JavaProxyInterface {
    @Override
    public void gotoSchool() {
        System.out.println("gotoSchool");
    }
    @Override
    public void gotoWork() {
        System.out.println("gotoWork");
    }
    @Override
    public void oneDay() {
        gotoSchool();
        gotoWork();
    }
    @Override
    public final void oneDayFinal() {
        gotoSchool();
        gotoWork();
    }
}
