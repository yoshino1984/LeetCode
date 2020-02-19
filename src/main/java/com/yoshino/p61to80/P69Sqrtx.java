package com.yoshino.p61to80;

public class P69Sqrtx {

    /**
     * 边缘数据越界，乘法更容易越界，可以考虑改成除法计算的形式（相应判断条件也应该修改）
     * 二分查找法 时间复杂度O(logN)
     *
     * @param x
     * @return
     */
    public static int mySqrt(int x) {
        return x == 1 ? 1 : findSqrt(0, x > 46341 ? 46341 : x, x);
    }

    static int findSqrt(int low, int high, int x) {
        if (low + 1 == high) {
            return low;
        }
        int mid = (low + high) / 2;
        int product = mid * mid;
        if (product == x) {
            return mid;
        } else if (product > x) {
            return findSqrt(low, mid, x);
        } else {
            return findSqrt(mid, high, x);
        }
    }

    public static void main(String[] args) {
        System.out.println(Math.sqrt(2147483647));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(mySqrt(1));
        System.out.println(mySqrt(2));
        System.out.println(mySqrt(4));
        System.out.println(mySqrt(5));
        System.out.println(mySqrt(8));
        System.out.println(mySqrt(16));
        System.out.println(mySqrt(2147395599));
        System.out.println(mySqrt(2147395600));
    }
}
