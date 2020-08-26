package com.yoshino.p201to220;

/**
 * 数字范围按位与
 **/
public class P201BitwiseAndOfNumbersRange {

    public int rangeBitwiseAnd(int m, int n) {
        int count = 0;
        for (; m != n; count++) {
            m >>= 1;
            n >>= 1;
        }
        return m << count;
    }

}
