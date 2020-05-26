package com.yoshino.p21to40;

import com.google.common.base.Joiner;
import com.yoshino.model.ListNode;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class P40ZuiXiaoDeKgeShuLcof {

    /**
     * 排序方法
     * 时间复杂度O(NlogN)
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] ret = new int[k];
        System.arraycopy(arr, 0, ret, 0, k);
        return ret;
    }

    public static void main(String[] args) {
         Joiner STRING_JOINER = Joiner.on("+");

        System.out.println(STRING_JOINER.join(1, 2));
    }
}
