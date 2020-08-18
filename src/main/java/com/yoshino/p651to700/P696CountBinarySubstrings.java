package com.yoshino.p651to700;

import java.util.ArrayList;
import java.util.List;

/**
 * 计数二进制子串
 **/
public class P696CountBinarySubstrings {

    public int countBinarySubstrings(String s) {
        if (s.length() <= 1) {
            return 0;
        }
        char[] chars = s.toCharArray();
        List<Integer> counter = new ArrayList<>();
        int count = 0;
        char last = s.charAt(0);
        for (char ch : chars) {
            if (ch == last) {
                count++;
            } else {
                counter.add(count);
                count = 1;
                last = ch;
            }
        }
        counter.add(count);

        int ans = 0;
        for (int i = 1; i < counter.size(); i++) {
            ans += Math.min(counter.get(i - 1), counter.get(i));
        }
        return ans;
    }
}
