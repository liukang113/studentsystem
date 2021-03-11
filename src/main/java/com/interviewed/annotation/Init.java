package com.interviewed.annotation;

import java.lang.annotation.*;

/**
 * @author: kang.liu
 * @since : 2019/3/10 6:07 PM
 * @desc:
 */



@Documented
@Inherited
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Init {
}
