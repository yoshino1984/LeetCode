package com.yoshino.p81to100;

/**
 * 合并两个有序数组
 * 移动数组的时间复杂度为O(M)，合并的时间复杂度为O(M+N)，因此时间复杂度为O(M+N)
 **/
public class P88MergeSortedArray {

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        // 从大到小合并都按nums1
        int index1 = m - 1;
        int index2 = n - 1;
        for (int i = m + n - 1; i >= 0; i++) {
            if (index1 >= 0 && index2 >= 0) {
                nums1[i] = nums2[index2] > nums1[index1] ? nums2[index2--] : nums1[index1--];
            } else {
                break;
            }
        }
        // 如果是nums2还未遍历完成的情况，则将nums2剩余元素合并到nums1
        if (index2 >= 0) {
            System.arraycopy(nums2, 0, nums1, 0, index2 + 1);
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 首先将nums1后移，然后合并
        for (int i = 0; i < m; i++) {
            nums1[n + m - i - 1] = nums1[m - 1 - i];
        }
        int index1 = n;
        int index2 = 0;
        // 合并
        for (int i = 0; i < m + n; i++) {
            // nums2遍历完，或者 当nums1未遍历完，进行值大小比对
            if (index2 == n || (index1 < (m + n) && nums1[index1] <= nums2[index2])) {
                nums1[i] = nums1[index1++];
            } else {
                nums1[i] = nums2[index2++];
            }
        }
    }
}
