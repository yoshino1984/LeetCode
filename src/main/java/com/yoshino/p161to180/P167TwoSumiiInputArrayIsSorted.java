package com.yoshino.p161to180;

/**
 * 两数之和
 *
 * @author wangxin
 * 2020/7/20 23:28
 * @since
 **/
public class P167TwoSumiiInputArrayIsSorted {

    public int[] twoSum(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                break;
            } else if (sum < target) {
                low++;
            } else {
                high--;
            }
        }

        return new int[]{low + 1, high + 1};
    }
}
