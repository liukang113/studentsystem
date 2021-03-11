package com.back;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 〈功能简述〉<br>
 *
 * @author : liukang
 * @version : 1.0
 * @date :2020-09-21 21:06
 * @since : 1.0
 **/
public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.next();
        if (null == next || next.length() == 0) {
            return;
        }
        /**
         * 先计算出所有子串
         * 再集合中筛选O出现两次的
         */
        List<String> result = new ArrayList();

        for (int i = 0; i < next.length(); i++) {
            for (int j = i + 1; j < next.length(); j++) {
                String substr = next.substring(i, j);
                result.add(substr);
            }
        }

        System.out.println(result);
        // 筛选"O" 出现两次的
        List<String> dest = result.stream().filter(s -> appearNumber(s) / 2 == 0)
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
        System.out.println(dest);
        System.out.println(dest.get(dest.size() - 1).length());
    }

    /**
     * 出现次数
     *
     * @param srcText
     * @return
     */
    private static int appearNumber(String srcText) {
        String[] split = srcText.split("");
        return Arrays.asList(split).stream().filter(s -> s.equals("o")).collect(Collectors.toList()).size();
    }

}
