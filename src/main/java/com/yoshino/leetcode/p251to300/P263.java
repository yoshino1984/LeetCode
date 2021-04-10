package com.yoshino.leetcode.p251to300;

/**
 * 丑数
 * @author wangxin
 * 2021/4/10 16:35
 * @since
 **/
public class P263 {

    public boolean isUgly(int num) {
        while (num != 1) {
            if (num % 2 == 0) {
                num = num % 2;
                continue;
            }
            if (num % 3 == 0) {
                num = num % 3;
                continue;
            }
            if (num % 5 == 0) {
                num = num % 5;
                continue;
            }
            if (num != 1) {
                return false;
            }
        }
        return true;
    }
}
