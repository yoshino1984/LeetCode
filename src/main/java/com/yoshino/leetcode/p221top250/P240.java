package com.yoshino.leetcode.p221top250;

/**
 * @author wangxin
 * 2021/4/1 03:20
 * @since
 **/
public class P240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        for (int i = 0; i < rowLen; i++) {
            int[] arr = matrix[i];
            if (arr[0] > target) {
                break;
            }
            if (arr[colLen - 1] < target) {
                continue;
            }
            if (findTarget(arr, target)) {
                return true;
            }
        }
        return false;
    }

    private boolean findTarget(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
