package com.yiqizuoye.pojo.regular_expression;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * Author: kang.liu
 * Date  : 2018/11/27 11:05
 * Description:
 */
public class RegularExpression {
    public static Pattern pattern = Pattern.compile("\\pP");


    public static String removePunctuation(String query) {
        Matcher m = pattern.matcher(query);
        String newQuery = m.replaceAll(" ");
        return newQuery;
    }

    public static void main(String[] args) {
        String str = "as,as[as[,asasnkjlaksdj] ";
        System.out.println("result" + removePunctuation(str));
    }

    @Test
    public void testRegular() {

    }
}