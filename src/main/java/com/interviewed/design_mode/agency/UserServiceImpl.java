package com.interviewed.design_mode.agency;

/**
 * Created with IntelliJ IDEA.
 * Author: kang.liu
 * Date  : 2019/1/28 19:36
 * Description:
 */
public class UserServiceImpl implements UserService {
    @Override
    public String getName(int id) {
        System.out.println("------getName------");
        return "Tom";
    }

    @Override
    public String getName(int id, String Name) {
        return "姓名" + Name + "  id" + id;
    }

    @Override
    public Integer getAge(int id) {
        System.out.println("------getAge------");
        return 10;
    }
}