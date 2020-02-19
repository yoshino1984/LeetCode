package com.yoshino.p61to80;

import com.alibaba.fastjson.JSON;

public class P75SortColors {

    public void sortColors(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int curr = 0;

        while (curr <= high){
            if (nums[curr] == 0) {
                swap(nums, low, curr);
                low++;
                curr++;
            } else if (nums[curr] == 2) {
                swap(nums, high, curr);
                high--;
            } else {
                curr++;
            }
        }
    }

    private void swap(int[] nums, int low, int i) {
        int temp = nums[low];
        nums[low] = nums[i];
        nums[i] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,0,2,1,1,0};
//        int[] nums = new int[]{1,2,0};
        new P75SortColors().sortColors(nums);
        System.out.println(JSON.toJSONString(nums));
    }

}
