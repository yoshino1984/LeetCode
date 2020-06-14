package com.yoshino.model;

import java.util.*;

/**
 * 刻意练习地方
 *
 * @author wangxin
 * 2020/6/11 20:51
 * @since
 **/
public class Solution {


    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        return findTarget(matrix, target, 0, matrix.length * matrix[0].length - 1);
    }

    private boolean findTarget(int[][] matrix, int target, int low, int high) {
        if (low > high) {
            return false;
        }
        int mid = low + (high - low) / 2;
        int row = mid / matrix[0].length;
        int col = mid % matrix[0].length;
        if (matrix[row][col] == target) {
            return true;
        } else if (matrix[row][col] < target) {
            return findTarget(matrix, target, mid + 1, high);
        } else {
            return findTarget(matrix, target, low, mid - 1);
        }
    }

    public int findMin(int[] nums) {
        if (nums[0] <= nums[nums.length - 1]) {
            return nums[0];
        }
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // 进行mid位置左右是否符合条件的检查
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            } else if (nums[mid] < nums[mid - 1]) {
                return nums[mid];
            } else if (nums[mid] > nums[0]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return nums[0];
    }
}
