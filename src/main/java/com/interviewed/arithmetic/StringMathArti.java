package com.interviewed.arithmetic;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * ${DESCRIPTION}
 *
 * @author : liukang
 * @date :2020-09-05 15:33
 **/
public class StringMathArti {

    private static Map<Character, Character> brackets = new HashMap<>();

    static {
        brackets.put(')', '(');
        brackets.put(']', '[');
        brackets.put('}', '{');
    }


    /**
     * 判断给定字符串中的括号是否匹配
     */
    @Test
    public void compareBracket() {
        String sourceStr = "(){}";
        boolean result = isMatch(sourceStr);
        System.out.println("括号是否匹配 ：" + result);
    }

    /**
     * 给定字符串是否是回文以及给出回文数
     */
    @Test
    public void compareIsHuiwen() {
        String sourceStr = "abccddcba";
        boolean result = isHuiwen(sourceStr);
        System.out.println("是否回文 ：" + result);
    }





    /**
     * <>
     * 回文数”就是正读倒读都一样的整数。如奇数个数字：98789，这个数字正读是98789 倒读也是98789。
     * 偶数个数字3223也是回文数。字母 abcba 也是回文。
     * </>
     *
     * @param sourceStr
     * @return
     */
    public boolean isHuiwen(String sourceStr) {
        int length = sourceStr.length();
        for (int i = 0; i < length / 2; i++) {
            if (sourceStr.toCharArray()[i] != sourceStr.toCharArray()[length - i - 1]) {
                return false;
            }
        }
        return true;
    }


    /**
     * 使用栈的特性：挨个比较，入栈和出栈
     * <>
     * 是左括号就入栈
     * 是右括号就将已经入栈的弹出拿出来比较（定义好比较值）
     * </>
     *
     * @param sourceStr
     * @return
     */
    public static boolean isMatch(String sourceStr) {
        if (null == sourceStr) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : sourceStr.toCharArray()) {
            // 先匹配左括号
            if (brackets.containsValue(c)) {
                stack.push(c);
            } else if (brackets.containsKey(c)) {
                if (stack.empty() || !stack.pop().equals(brackets.get(c))) {
                    // 遍历完成，如果没有多余的左括号，则匹配
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
