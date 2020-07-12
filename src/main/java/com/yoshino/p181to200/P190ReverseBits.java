package com.yoshino.p181to200;

/**
 * 颠倒二进制位
 **/
public class P190ReverseBits {

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans += ((n >> i) & 1) << (31 - i) ;
        }

        return ans;
    }

}
