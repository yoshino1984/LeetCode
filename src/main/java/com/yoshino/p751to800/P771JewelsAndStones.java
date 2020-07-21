package com.yoshino.p751to800;

import java.util.HashSet;
import java.util.Set;

/**
 * 宝石与石头
 **/
public class P771JewelsAndStones {

    public int numJewelsInStones(String J, String S) {
        Set<Character> jewels = new HashSet<>();
        for (char ch : J.toCharArray()) {
            jewels.add(ch);
        }

        int count = 0;
        for (char ch : S.toCharArray()) {
            if (jewels.contains(ch)) {
                count++;
            }
        }

        return count;
    }
}
