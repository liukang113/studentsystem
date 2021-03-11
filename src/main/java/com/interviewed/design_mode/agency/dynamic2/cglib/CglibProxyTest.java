package com.interviewed.design_mode.agency.dynamic2.cglib;

//import com.interviewed.design_mode.agency.dynamic2.CglibTestSon;
//import net.sf.cglib.proxy.Callback;
//import net.sf.cglib.proxy.Enhancer;

/**
 * @author: kang.liu
 * @since : 2019/3/10 6:07 PM
 */
// 静态代理
public class CglibProxyTest {
    public static void main(String[] args) {
//        CglibTestSon CglibTestSon = new CglibTestSon();
//        Enhancer enhancer = new Enhancer();
//        Callback s = new MethdInvoker(CglibTestSon);
//        enhancer.setSuperclass(CglibTestSon.class);
//        Callback callbacks[] = new Callback[]{s};
//        enhancer.setCallbacks(callbacks);
//        CglibTestSon CglibTestSon2 = (CglibTestSon) enhancer.create();
//        CglibTestSon2.gotoHome();
//        CglibTestSon2.gotoSchool();
//        ////这里可以看到这个类以及被代理，在执行方法前会执行aopMethod（）。
//        // 这里需要注意的是oneDay（）方法和onedayFinal（）的区别。
//        // onedayFinal的方法aopMethod执行2次，oneDay的aopMethod执行1次 ,注意这里和jdk的代理的区别
//        CglibTestSon2.oneday();
//        CglibTestSon2.onedayFinal();
    }
}
