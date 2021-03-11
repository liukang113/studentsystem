package com.yiqizuoye.pojo;

import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

/**
 * Created with IntelliJ IDEA.
 * Author: kang.liu
 * Date  : 2018/4/16 17:04
 * Description:
 */
public class TestMain {
    public static void main(String[] args) {

        String REDIS_SPLIT_TOKEN = ",";
        List<String> stringList = Lists.newArrayList();
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        stringList.add("4");
        stringList.add("5");
        stringList.add("6");
        String data = null;
        String join = StringUtils.join(stringList, REDIS_SPLIT_TOKEN);

        System.out.println(join);
        /*
        List<String > parse  = StringUtils.toList(join,String.class);
        System.out.println(parse);
        String data=null;

        System.out.println(data+ UUID.randomUUID().toString().replace("-",""));
        data= UUID.randomUUID().toString().replace("-","");
        System.out.println("===================="+data);
        stringList = stringList.subList(stringList.size()-1,stringList.size());
        System.out.println(stringList);
        */

        for (String str : stringList) {
            data = StringUtils.isNotBlank(data) ? (data + "," + str) : str;
        }
        System.out.println(data);
        List<String> subList = stringList.subList(2, 5);
        System.out.println(subList);

        System.out.println("==========================================");
        LinkedList<String> ll = new LinkedList<>();
        ll.add("a");
        ll.add("b");
        ll.add("c");
        ll.subList(1, 2).clear();
        List<String> list = ll.subList(1, 2);
        System.out.println(ll);
        System.out.println(list);
        Function<Integer, Integer> function = x -> x * 3;

        FunctionInner<Number, Number> functionInner = new FunctionInner<Number, Number>() {
            @Override
            public int apply(int arg) {
                return arg * 3;
            }
        };
    }

    FunctionInner<Number, Number> compose(final FunctionInner<Number, Number> functionInner1, final FunctionInner<Number, Number> functionInner2) {
        return new FunctionInner<Number, Number>() {
            @Override
            public int apply(int arg) {
                return functionInner1.apply(functionInner1.apply(arg));
            }
        };
    }


    /*
    static <T, U, V> FunctionInner<FunctionInner<T, U>,
            FunctionInner<FunctionInner<U, V>, FunctionInner<T, V>>
            > highCompose() {
        return (int x) -> {
            return y -> {
                return z -> {
                    return x.apply(y.apply(z));
                };
            };
        };
    }*/

}