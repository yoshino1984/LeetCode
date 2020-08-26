package com.yoshino.p61to80;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 **/
public class P78Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        int num = (1 << nums.length) - 1;
        List<List<Integer>> ans = new ArrayList<>();
        while (num >= 0) {
            ans.add(genSubset(num--, nums));
        }
        return ans;
    }

    private List<Integer> genSubset(int bit, int[] nums) {
        List<Integer> subset = new ArrayList<>();
        for (int num : nums) {
            if ((bit & 1) == 1) {
                subset.add(num);
            }
            bit >>= 1;
            if (bit == 0) {
                break;
            }
        }
        return subset;
    }
}
