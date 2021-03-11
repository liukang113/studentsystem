package com.yiqizuoye.pojo.efficient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author: kang.liu
 * @since : 2019/3/10 6:07 PM
 */

@Setter
@Getter
@ToString
@AllArgsConstructor
public class PeopleGroup implements Serializable {
    private String name;
    private Integer age;
    private Integer gender;

}
