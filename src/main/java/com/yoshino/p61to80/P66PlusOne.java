package com.yoshino.p61to80;

/**
 * 加一
 **/
public class P66PlusOne {


    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        // 全进位的情况
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
