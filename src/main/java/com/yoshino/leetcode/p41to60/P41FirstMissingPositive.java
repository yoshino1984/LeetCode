package com.yoshino.leetcode.p41to60;

public class P41FirstMissingPositive {

    /**
     * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
     * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
     *
     * 思路：可以使用数组的下标存储对应的正整数，这样最小的正整数只需要一次遍历即可，（ps：注意下标0处的数字）
     *
     * @param nums
     * @return
     */
    public static int firstMissingPositive(int[] nums) {
        if (nums.length == 0) {
            return 1;
        }
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == nums[i]) {
                continue;
            }
            int nextIndex = nums[i];
            while (nextIndex < nums.length && nextIndex > 0 && nums[nextIndex] != nextIndex) {
                temp = nums[nextIndex];
                nums[nums[i]] = nextIndex;
                nums[i] = temp;
                nextIndex = temp;
            }
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums[0] == nums.length ? nums.length + 1 : nums.length;
    }

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{1,2,0}));
        System.out.println(firstMissingPositive(new int[]{3,4,-1,1}));
        System.out.println(firstMissingPositive(new int[]{7,8,9,11,12}));
        System.out.println(firstMissingPositive(new int[]{-1}));
        System.out.println(firstMissingPositive(new int[]{-1, -2}));
        System.out.println(firstMissingPositive(new int[]{0}));
        System.out.println(firstMissingPositive(new int[]{1}));
        System.out.println(firstMissingPositive(new int[]{1, 2}));
        System.out.println(firstMissingPositive(new int[]{1, 2, 4}));
    }
}
