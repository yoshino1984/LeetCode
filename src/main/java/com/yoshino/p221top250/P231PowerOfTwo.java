package com.yoshino.p221top250;

/**
 * 2的幂
 **/
public class P231PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
