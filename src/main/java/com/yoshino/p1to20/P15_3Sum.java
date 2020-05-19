package com.yoshino.p1to20;

import java.util.*;

public class P15_3Sum {

    /**
     * 暴力解法 超出时间限制
     * 时间复杂度O(N^3)
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum1(int[] nums) {
        if (nums.length < 3) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        Set<List<Integer>> retList = new LinkedHashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        retList.add(List.of(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return new ArrayList<>(retList);
    }

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

        List<List<Integer>> retList = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            int target = -nums[i];
            int low = i + 1, high = nums.length - 1;
            while (low < high) {
                int sum = nums[low] + nums[high];
                if (sum == target) {
                    retList.add(List.of(nums[i], nums[low], nums[high]));
                    while (low < high && nums[low] == nums[++low]);
                    while (low < high && nums[high] == nums[--high]);
                } else if (sum < target){
                    low++;
                } else {
                    high--;
                }
            }
        }
        return retList;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum(new int[]{0, -1, -1, -1, -1, -1, -1, -1, 0, 0, 2}));
        System.out.println(threeSum(new int[]{-1, 0, 1, 2}));
        System.out.println(threeSum(new int[]{0,-4,-1,-4,-2,-3,2,2}));
        System.out.println(threeSum(new int[]{-1,0,1,0}));
    }


}
