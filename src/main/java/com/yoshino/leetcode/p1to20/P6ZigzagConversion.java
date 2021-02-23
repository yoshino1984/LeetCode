package com.yoshino.leetcode.p1to20;

import java.util.ArrayList;
import java.util.List;

/**
 * Z字形变换
 **/
public class P6ZigzagConversion {
    public String convert(String s, int numRows) {
        if (numRows <= 1 || s.length() == 0) {
            return s;
        }
        List<StringBuilder> ansList = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            ansList.add(new StringBuilder());
        }
        boolean goingUp = false;
        int curRow = 0;
        for (int i = 0; i < s.length(); i++) {
            ansList.get(curRow).append(s.charAt(i));
            if (curRow == numRows - 1 || curRow == 0) {
                goingUp = !goingUp;
            }
            curRow += goingUp ? 1 : -1;
        }
        StringBuilder ans = new StringBuilder();
        for (StringBuilder stringBuilder : ansList) {
            ans.append(stringBuilder);
        }
        return ans.toString();
    }
}
