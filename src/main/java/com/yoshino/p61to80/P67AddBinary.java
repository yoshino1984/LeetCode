package com.yoshino.p61to80;

/**
 * 二进制求和
 **/
public class P67AddBinary {

    public String addBinary(String a, String b) {
        char[] ans = new char[Math.max(a.length(), b.length()) + 1];

        int last = 0;
        for (int i = 0; i < ans.length; i++) {
            int aN = i >= a.length() ? 0 : getInt(a.charAt(a.length() - i - 1));
            int bN = i >= b.length() ? 0 : getInt(b.charAt(b.length() - i - 1));
            int sum = aN + bN + last;
            ans[ans.length - i - 1] = (char) ('0' + sum % 2);
            last = sum / 2;
        }
        String ansStr = String.valueOf(ans);
        return ansStr.startsWith("0") ? ansStr.substring(1) : ansStr;
    }

    private int getInt(char charAt) {
        return charAt - '0';
    }

}
