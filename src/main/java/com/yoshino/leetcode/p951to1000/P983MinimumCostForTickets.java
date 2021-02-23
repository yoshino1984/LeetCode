package com.yoshino.leetcode.p951to1000;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P983MinimumCostForTickets {


    /**
     * 当前时间点的选择是由未来的可能性决定的，因此如果未来已经确定，那么当前的选择也就确定了
     * 因此我们从未来进行倒退，确定未来最小的解决方案，然后得出当前最合理的选择（依次将时间点向前移动，即可得出最优解）
     *
     * dp(i) = min(dp(i+1).)
     */
    int[] costs;
    Integer[] memo;
    Set<Integer> dayset;
    public int mincostTickets(int[] days, int[] costs) {
        this.costs = costs;
        memo = new Integer[366];
        int size = (int) (days.length * 1.25) + 1;
        dayset = new HashSet<>(size);
        for (int d : days) {
            dayset.add(d);
        }

        return dp(1);
    }

    private int dp(int day) {
        if (day > 365) {
            return 0;
        }
        if (memo[day] != null) {
            return memo[day];
        }

        int ans;
        if (dayset.contains(day)) {
            ans = Math.min(dp(day + 1) + costs[0], dp(day + 7) + costs[1]);
            ans = Math.min(ans, dp(day + 30) + costs[2]);
        } else {
            ans = dp(day + 1);
        }
        memo[day] = ans;

        return ans;
    }


    /**
     * total[i] = total[i - 1] + days[i]的选择
     * @param days
     * @param costs
     * @return
     */
    public static int mincostTickets2(int[] days, int[] costs) {
        int size = (int)((days.length * 3) / 0.75);
        dayCostTypeMap = new HashMap<>(size);
        minCost = Integer.MAX_VALUE;
        mincostTickets(days, costs, 0, 0, 0);
        return minCost;
    }

    private static void mincostTickets(int[] days, int[] costs, int dayIndex, int curCost, int expirationDay) {
        if (curCost >= minCost) {
            return;
        }
        while (dayIndex < days.length && expirationDay > days[dayIndex]) {
            dayIndex++;
        }
        if (dayIndex >= days.length) {
            minCost = Math.min(minCost, curCost);
            return;
        }
        for (int i = costs.length - 1; i >= 0; i--) {
            int newExpirationDay = days[dayIndex] + dayLongs[i];
            int newCurCost = curCost + costs[i];
            if (dayCostTypeMap.getOrDefault(newExpirationDay, Integer.MAX_VALUE) > newCurCost) {
                mincostTickets(days, costs, dayIndex + 1, newCurCost, newExpirationDay);
                dayCostTypeMap.put(newExpirationDay, newCurCost);
            }
        }
    }

    private static int minCost = 0;
    private static int[] dayLongs = new int[]{1, 7, 30};
    private static Map<Integer, Integer> dayCostTypeMap;

    public static void main(String[] args) {
        for (int i = 0; i < 365; i++) {
            System.out.print(i + ",");
        }
        System.out.println(new P983MinimumCostForTickets().mincostTickets(new int[]{1,2,3}, new int[]{2, 7, 15}));
//        System.out.println(mincostTickets2(new int[]{3,5,6,7,8,10,12,15,16,18,19,21,23,24,25,26,27,28,29,37,38,39,40,48,49,52,54,55,57,61,63,65,66,69,73,75,77,78,81,83,84,85,88,89,90,91,93,94,96,99}, new int[]{5,26,98}));
//        System.out.println(mincostTickets2(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77}, new int[]{5,26,98}));
        System.out.println(new P983MinimumCostForTickets().mincostTickets(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122,123,124,125,126,127,128,129,130,131,132,133,134,135,136,137,138,139,140,141,142,143,144,145,146,147,148,149,150,151,152,153,154,155,156,157,158,159,160,161,162,163,164,165,166,167,168,169,170,171,172,173,174,175,176,177,178,179,180,181,182,183,184,185,186,187,188,189,190,191,192,193,194,195,196,197,198,199,200,201,202,203,204,205,206,207,208,209,210,211,212,213,214,215,216,217,218,219,220,221,222,223,224,225,226,227,228,229,230,231,232,233,234,235,236,237,238,239,240,241,242,243,244,245,246,247,248,249,250,251,252,253,254,255,256,257,258,259,260,261,262,263,264,265,266,267,268,269,270,271,272,273,274,275,276,277,278,279,280,281,282,283,284,285,286,287,288,289,290,291,292,293,294,295,296,297,298,299,300,301,302,303,304,305,306,307,308,309,310,311,312,313,314,315,316,317,318,319,320,321,322,323,324,325,326,327,328,329,330,331,332,333,334,335,336,337,338,339,340,341,342,343,344,345,346,347,348,349,350,351,352,353,354,355,356,357,358,359,360,361,362,363}, new int[]{5,26,98}));
    }
}