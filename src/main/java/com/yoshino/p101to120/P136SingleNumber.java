package com.yoshino.p101to120;

/**
 * 只出现一次的数字
 **/
public class P136SingleNumber {

    /**
     * 异或方式，两个相同的数字异或结果为0， 0异或一个数字a结果为a
     * （哈希表等计数解法略去，空间复杂度O(N)）
     * 时间复杂度O(N)
     * 空间复杂度O(1)
     */
    public int singleNumber(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans ^= nums[i];
        }
        return ans;
    }

}
