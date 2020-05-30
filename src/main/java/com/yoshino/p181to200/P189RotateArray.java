package com.yoshino.p181to200;

/**
 * 旋转数组
 * @author wangxin
 * 2020/5/30 08:50
 * @since
 **/
public class P189RotateArray {

    public void rotate1(int[] nums, int k) {
        if (nums.length == 0) {
            return;
        }
        k %= nums.length;
        for (int i = 0; i < k; i++) {
            int temp = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }

    public void rotate2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void rotate3(int[] nums, int k) {
        if (nums.length == 0) {
            return;
        }
        k %= nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int cur = start;
            int prev = nums[start];
            do {
                int next = (cur + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                cur = next;
                count++;
            } while (start != cur);
        }

    }


}
