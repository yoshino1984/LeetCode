package com.yoshino.p1to20;

public class P8StringToIntegerAtoi {

    /**
     * 自己实现方法，使用long的形式的话，数据判断则会更加简洁
     * O(N)
     * @param str
     * @return
     */
    public static int myAtoi(String str) {
        int res = 0;
        StringBuffer intStr = new StringBuffer();
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        int negativeCnt = 0;
        int positiveCnt = 0;
        int intCnt = 0;
        for (int i =0; i < str.length(); i++) {
            char item = str.charAt(i);
            if (item == '-') {
                if (intCnt > 0 || positiveCnt > 0 || ++negativeCnt > 1) {
                    break;
                }
            } else if (item == '+') {
                if (intCnt > 0 || negativeCnt > 0 || ++positiveCnt > 1) {
                    break;
                }

            } else if (item >= '0' && item <= '9') {
                intCnt++;
                intStr.append(item);
            } else {
                break;
            }
        }
        if (intCnt == 0) {
            return res;
        }
        int zeroCnt = 0;
        for (int i = 0; i < intStr.length(); i++) {
            if (intStr.charAt(i) == '0') {
                zeroCnt++;
            } else {
                break;
            }
        }
        if (intCnt == zeroCnt) {
            return 0;
        }
        String intStrNoZeroPre = intStr.toString().substring(zeroCnt, intStr.length());
        intCnt = intCnt - zeroCnt;
        if (intCnt > 10) {
            res = negativeCnt > 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        } else if (intCnt <= 9) {
            res = Integer.parseInt((negativeCnt > 0 ? "-" : "") + intStrNoZeroPre);
        } else {
            int maxPrefix = 214748364;
            int strPrefix = Integer.parseInt(intStrNoZeroPre.substring(0, 9));
            if (strPrefix > maxPrefix) {
                res = negativeCnt > 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            } else if(strPrefix < maxPrefix) {
                res = Integer.parseInt((negativeCnt > 0 ? "-" : "") + intStrNoZeroPre);
            } else if (negativeCnt > 0){
                res = Integer.parseInt(intStrNoZeroPre.substring(9, 10)) > 7
                    ? Integer.MIN_VALUE : Integer.parseInt("-" + intStrNoZeroPre);
            } else {
                res = Integer.parseInt(intStrNoZeroPre.substring(9, 10)) > 6
                    ? Integer.MAX_VALUE : Integer.parseInt(intStrNoZeroPre);
            }
        }
        return res;
    }


    public static int myAtoi2(String str) {
        StringBuffer intStr = new StringBuffer();
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        int negativeCnt = 0;
        int positiveCnt = 0;
        int intCnt = 0;
        for (int i =0; i < str.length(); i++) {
            char item = str.charAt(i);
            if (item == '-') {
                if (intCnt > 0 || positiveCnt > 0 || ++negativeCnt > 1) {
                    break;
                }
            } else if (item == '+') {
                if (intCnt > 0 || negativeCnt > 0 || ++positiveCnt > 1) {
                    break;
                }

            } else if (item >= '0' && item <= '9') {
                intCnt++;
                intStr.append(item);
            } else {
                break;
            }
        }
        if (intCnt == 0) {
            return 0;
        }
        int zeroCnt = 0;
        for (int i = 0; i < intStr.length(); i++) {
            if (intStr.charAt(i) == '0') {
                zeroCnt++;
            } else {
                break;
            }
        }
        if (intCnt == zeroCnt) {
            return 0;
        }
        String intStrNoZeroPre = intStr.toString().substring(zeroCnt, intStr.length());
        intCnt = intCnt - zeroCnt;
        if (intCnt > 10) {
            return negativeCnt > 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        long intLong = Long.parseLong((negativeCnt > 0 ? "-" : "") + intStrNoZeroPre);
        if (intLong <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else if (intLong >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else {
            return (int) intLong;
        }

    }

    public static void main(String[] args) {
        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("-91283472332"));
        System.out.println(myAtoi("-2147483649"));
        System.out.println(myAtoi("-2147483647"));
        System.out.println(myAtoi("2147483646"));
        System.out.println(myAtoi("2147483648"));
        System.out.println(myAtoi("+2147483648"));
        System.out.println(myAtoi("+-2147483648"));
        System.out.println(myAtoi("+-+-2147483648"));
        System.out.println(myAtoi("++-2147483648"));
        System.out.println(myAtoi("-+-2147483648"));
        System.out.println(myAtoi("  0000000000012345678"));
        System.out.println(myAtoi("2147483800"));
    }
}
