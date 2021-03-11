package com.interviewed.design_mode.agency;

/**
 * Created with IntelliJ IDEA.
 * Author: kang.liu
 * Date  : 2019/1/28 19:35
 * Description:
 */
public interface UserService {
    public String getName(int id);

    public String getName(int id, String Name);

    public Integer getAge(int id);
}