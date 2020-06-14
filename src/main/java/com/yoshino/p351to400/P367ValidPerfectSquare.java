package com.yoshino.p351to400;

/**
 * 有效的完全平方数
 **/
public class P367ValidPerfectSquare {

    /**
     * 二分查找
     * 时间复杂度O(logN)
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        long low = 0, high = num;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long res = mid * mid;
            if (res == (long) num) {
                return true;
            } else if (res < num) {
                if ((mid + 1) * (mid + 1) > num) {
                    return false;
                }
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
