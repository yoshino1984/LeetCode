package com.yoshino.p251to300;

import java.util.Arrays;

public class P283MoveZeros {

    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != j) {
                    swap(nums, i, j);
                }
                j++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2,1,0,3,12};
        new P283MoveZeros().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
        nums = new int[] {0};
        new P283MoveZeros().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
        nums = new int[] {1, 2};
        new P283MoveZeros().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
        nums = new int[] {0, 0, 1};
        new P283MoveZeros().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
        nums = new int[] {0, 0, 1, 2};
        new P283MoveZeros().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
