package com.yoshino.p501to600;

import java.util.HashMap;
import java.util.Map;

/**
 * 斐波那契数
 *
 * @author wangxin
 * 2020/5/3 16:21
 * @since
 **/
public class P509FibonacciNumber {

    public static int fib(int n) {
        return f(n);
    }

    private static final Map<Integer, Long> retMap = new HashMap<>();
    public static int f(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (retMap.containsKey(n)) {
            return retMap.get(n).intValue();
        }
        Long ret = (long) (f(n - 1) + f(n - 2));
        retMap.put(n, ret);
        return ret.intValue();
    }

    public static void main(String[] args) {
        System.out.println(fib(30));
    }
}
