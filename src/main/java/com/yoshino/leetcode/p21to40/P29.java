package com.yoshino.leetcode.p21to40;

/**
 * @author wangxin
 * 2021/4/10 17:09
 * @since
 **/
public class P29 {

    public int divide(int dividend, int divisor) {
        long result = 0;
        long sign = (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0) ? -1 : 1;
        long dividendLong = Math.abs(Long.valueOf(dividend));
        long divisorLong = Math.abs(Long.valueOf(divisor));
        while (dividendLong >= divisorLong) {
            long base = divisorLong;
            long sub = 1;
            while (base + base <= dividendLong) {
                base += base;
                sub += sub;
            }
            result += sub;
            dividendLong -= base;
        }
        return result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) (result * sign);
    }

    public static void main(String[] args) {
        System.out.println(new P29().divide(-2147483648, -1));
    }
}
