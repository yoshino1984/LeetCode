package com.yoshino.p501to600;

/**
 * 学生出勤记录II
 *
 **/
public class P522StudentAttendanceRecordii {

    /**
     * 动态规划
     * 时间复杂度O(N)
     * 空间复杂度O(N) 可优化为O(1)
     */
    public int checkRecord(int n) {
        // [长度][A的数量][末尾连续L的数量]
        long[][][] dp = new long[n + 1][2][3];
        dp[0][0][0] = 1;
        int mod = 1000000007;

        for (int i = 1; i <= n; i++) {
            dp[i][0][0] = (dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][0][2]) % mod ;
            dp[i][0][1] = dp[i - 1][0][0];
            dp[i][0][2] = dp[i - 1][0][1];
            dp[i][1][0] = (dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][0][2]
                + dp[i - 1][1][0] + dp[i - 1][1][1] + dp[i - 1][1][2]) % mod;
            dp[i][1][1] = dp[i - 1][1][0];
            dp[i][1][2] = dp[i - 1][1][1];
        }

        return (int) ((dp[n][0][0] + dp[n][0][1] + dp[n][0][2] + dp[n][1][0] + dp[n][1][1] + dp[n][1][2]) % mod);
    }


    public int checkRecord2(int n) {
        // [长度][A的数量][末尾连续L的数量]
        long dp00 = 1, dp01 = 0, dp02 = 0, dp10 = 0, dp11 = 0, dp12 = 0;
        int mod = 1000000007;

        for (int i = 1; i <= n; i++) {
            long t00 = dp00, t01 = dp01, t02 = dp02, t10 = dp10, t11 = dp11, t12 = dp12;
            dp00 = (t00 + t01 + t02) % mod ;
            dp01 = t00;
            dp02 = t01;
            dp10 = (t00 + t01 + t02 + t10 + t11 + t12) % mod;
            dp11 = t10;
            dp12 = t11;
        }

        return (int) ((dp00 + dp01 + dp02 + dp10 + dp11 + dp12) % mod);
    }

}
