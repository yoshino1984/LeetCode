package com.yoshino.leetcode.p101to120;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }
        result.add(Collections.singletonList(1));
        for (int rowIndex = 1; rowIndex < numRows; rowIndex++) {
            List<Integer> line = new ArrayList<>();
            List<Integer> last = result.get(result.size() - 1);
            line.add(1);
            for (int i = 1; i < rowIndex; i++) {
                line.add(last.get(i - 1) + last.get(i));
            }
            line.add(1);
            result.add(line);
        }

        return result;
    }
}
