package com.yoshino.p161to180;

public class P169MajorityElement {

    /**
     * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
     *
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     *
     * 因此，对多数元素进行计数即可
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int majorElement = nums[0];
        int majorCnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (majorElement == nums[i]) {
                majorCnt++;
            } else {
                majorCnt--;
                if (majorCnt < 0) {
                    majorElement = nums[i];
                    majorCnt = 1;
                }
            }
        }
        return majorElement;
    }
}
