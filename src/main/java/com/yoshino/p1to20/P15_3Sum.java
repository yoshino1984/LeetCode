package com.yoshino.p1to20;

import java.util.*;

public class P15_3Sum {

    /**
     * 相当于一找二的关系，从小到大遍历一个数，然后查找另外两个数的组合情况，
     * 去重：几种去重的情况
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);

        int sum = 0;
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i <= nums.length - 3; i++) {
            // 最小值大于0，则三数总和大于零
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                sum = nums[i] + nums[low] + nums[high];
                if (sum == 0) {
                    results.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    while (low < high && nums[low + 1] == nums[low]) {
                        low++;
                    }
                    while (low < high && nums[high - 1] == nums[high]) {
                        high--;
                    }
                    low++;
                    high--;
                } else if (sum < 0) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum(new int[]{0, 0, 0}));
        System.out.println(threeSum(new int[]{-1, 0, 1, 2}));
        System.out.println(threeSum(new int[]{0,-4,-1,-4,-2,-3,2,2}));
        System.out.println(threeSum(new int[]{-1,0,1,0}));
    }


}
