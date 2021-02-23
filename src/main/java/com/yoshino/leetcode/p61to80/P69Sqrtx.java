package com.yoshino.leetcode.p61to80;

public class P69Sqrtx {

    /**
     * 边缘数据越界，乘法更容易越界，可以考虑改成除法计算的形式（相应判断条件也应该修改）
     * 二分查找法 时间复杂度O(logN)
     *
     * @param x
     * @return
     */
    public static int mySqrt1(int x) {
        long low = 0, high = x, ans = -1;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (mid * mid <= (long) x) {
                low = mid + 1;
                ans = -1;
            } else {
                high = mid - 1;
            }
        }
        return (int) ans;
    }

    /**
     * 牛顿迭代法
     * @param x
     * @return
     */
    public static int mySqrt(int x) {
        long cur = x;
        while (cur * cur > (long)x) {
            cur = (cur + (long)x / cur) / 2;
        }
        return (int) cur;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt1(4));
        System.out.println(Math.sqrt(2147483647));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(mySqrt1(2));
        System.out.println(mySqrt1(4));
        System.out.println(mySqrt1(5));
        System.out.println(mySqrt1(8));
        System.out.println(mySqrt1(16));
        System.out.println(mySqrt1(2147395599));
        System.out.println(mySqrt1(2147395600));
    }
}
