package com.yoshino.p61to80;

public class P74SearchA2dMatrix {

    /**
     * 本质上是有序数组拆分成二维矩阵，二分查找算法
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        return findTarget(matrix, target, 0, matrix.length * matrix[0].length - 1);
    }

    private static boolean findTarget(int[][] matrix, int target, int low, int high) {
        if (low > high) {
            return false;
        }
        int mid = (low + high) / 2;
        int value = matrix[mid / matrix[0].length][mid % matrix[0].length];
        if (value == target) {
            return true;
        } else if (value < target){
            return findTarget(matrix, target, mid + 1, high);
        } else {
            return findTarget(matrix, target, low, mid - 1);
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
            {1,   3,  5,  7},
            {10, 11, 16, 20},
            {23, 30, 34, 50}
        };
        System.out.println(searchMatrix(matrix, 3));
    }

}
