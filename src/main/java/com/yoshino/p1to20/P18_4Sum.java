package com.yoshino.p1to20;

import com.alibaba.fastjson.JSON;

import java.util.*;

public class P18_4Sum {

    /**
     * 双指针法只能优化两个变量转换为一次遍历
     * 4数之和的求法就只能在确定两个数的前提下，使用双指针法求解剩余两个数（可以提前判断来提前跳出，剪枝减少计算量）
     * 时间复杂度O(N^3)
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> resSet = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 3; i++) {
            for (int j = i + 1; j < len - 2; j++) {
                int low = j + 1;
                int high = len - 1;
                while (low < high) {
                    int sum = nums[i] + nums[j] + nums[low] + nums[high];
                    if (sum == target) {
                        resSet.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        low++;
                        high--;
                    } else if (sum < target) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
            if (4 * nums[i] > target) {
                break;
            }
        }
        return new ArrayList<>(new HashSet<>(resSet));
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0)));
        System.out.println(JSON.toJSONString(fourSum(new int[]{0, 0, 0, 0}, 0)));
    }
}
