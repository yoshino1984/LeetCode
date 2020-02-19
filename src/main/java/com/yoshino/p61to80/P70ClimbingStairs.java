package com.yoshino.p61to80;

import java.util.HashMap;
import java.util.Map;

public class P70ClimbingStairs {

    /**
     * 使用缓存，减少重复计算，时间复杂度 O(N)
     */
    static Map<Integer, Integer> map ;

    public static int climbStairs(int n) {
        int size = (int) (n / 0.75 + 1);
        map = new HashMap<>(size);
        return subClimbStairs(n);
    }

    private static int subClimbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        Integer val = map.get(n);
        if (val == null) {
            val = subClimbStairs(n - 1) + subClimbStairs(n - 2);
            map.put(n, val);
            System.out.println(n + ":" + val);
        }
        return val;
    }

    public static void main(String[] args) {
        climbStairs(44);
    }


}
