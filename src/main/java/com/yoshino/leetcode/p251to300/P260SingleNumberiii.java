package com.yoshino.leetcode.p251to300;

/**
 * 只出现一次的数字iii
 *
 * @author wangxin
 * 2020/8/23 17:00
 * @since
 **/
public class P260SingleNumberiii {

    /**
     * 使用异或的性质获取
     * @param nums
     * @return
     */
    public int[] singleNumber(int[] nums) {
        int bitmask = 0;
        for (int num : nums) {
            bitmask ^= num;
        }

        // 获取最右的1
        int diff = bitmask & (-bitmask);
        int x = 0;
        // bitmask which will contain only x;
        for (int num : nums) {
            if ((num & diff) == diff) {
                x ^= num;
            }
        }

        int y = bitmask ^ x;
        return new int[]{x, y};
    }
}
