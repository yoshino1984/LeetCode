package com.yoshino.leetcode.p101to120;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author wangxin
 * 2021/4/23 18:07
 * @since
 **/
public class P119 {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> cur = Collections.singletonList(1);
        List<Integer> last;
        while (rowIndex-- > 0) {
            last = cur;
            cur = new ArrayList<>(last.size() + 1);
            cur.add(1);
            for (int i = 1; i < last.size(); i++) {
                cur.add(last.get(i - 1) + last.get(i));
            }
            cur.add(1);
        }

        return cur;
    }
}
