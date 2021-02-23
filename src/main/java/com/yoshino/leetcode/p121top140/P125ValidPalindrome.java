package com.yoshino.leetcode.p121top140;

/**
 * @author wangxin
 * 2020/5/19 20:21
 * @since
 **/
public class P125ValidPalindrome {

    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int head = 0, tail = s.length() - 1;
        while (head <= tail) {
            if (!Character.isLetterOrDigit(s.charAt(head))) {
                head++;
            } else if (!Character.isLetterOrDigit(s.charAt(tail))) {
                tail--;
            } else {
                if (Character.toLowerCase(s.charAt(head)) != Character.toLowerCase(s.charAt(tail))) {
                    return false;
                }
                head++;
                tail--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new P125ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"));;
        System.out.println(new P125ValidPalindrome().isPalindrome(".,"));
    }
}
