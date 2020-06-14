package com.yoshino.p301to350;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class P322CoinChange {

    /**
     * 动态规划：O(sn) 但是性能不太好。。。
     *
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        boolean update = false;
        Set<Integer> allIndexs = new HashSet<>();
        // 存储了上一次迭代达到的金额
        Set<Integer> lastUpdateIndexs = new HashSet<>();
        for (int i = 0; i < amount; i++) {
            // 初始化刚开始的情况
            if (i == 0) {
                for (int coin : coins) {
                    if (coin == amount) {
                        return i + 1;
                    } else if (coin < amount) {
                        lastUpdateIndexs.add(coin);
                        update = true;
                    }
                }
            } else {
                Set<Integer> curIndexs = new HashSet<>();
                for (Integer lastUpdateIndex : lastUpdateIndexs) {
                    for (int coin : coins) {
                        int sum = coin + lastUpdateIndex;
                        if (sum == amount) {
                            return i + 1;
                        } else if (sum < amount && !allIndexs.contains(sum)){
                            curIndexs.add(sum);
                            update = true;
                        }
                    }
                }
                lastUpdateIndexs = curIndexs;
            }
            allIndexs.addAll(lastUpdateIndexs);
            if (!update) {
                return -1;
            }
        }
        return -1;
    }

//    public static int coinChange2(int[] coins, int amount) {
//        if (amount == 0) {
//            return 0;
//        }
//    }

    public static void main(String[] args) {
//        System.out.println(coinChange2(new int[]{1, 2, 4}, 21));
    }
}
