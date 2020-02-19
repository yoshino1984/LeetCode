package com.yoshino.p501to600;

public class P556NextGreaterElementiii {

    /**
     * 时间复杂度O(N)
     * 空间复杂度O(1)
     * @param n
     * @return
     */
    public static int nextGreaterElement(int n) {
        String nStr = String.valueOf(n);
        long res = -1L;
        for (int i = nStr.length() - 2; i >= 0; i--) {
            if (nStr.charAt(i) < nStr.charAt(i + 1)) {
                char[] chars = nStr.toCharArray();
                int curi = i + 1;
                while (curi < nStr.length() && chars[i] < chars[curi]) {
                    curi++;
                }
                // 挑选一个稍大于当前的数，进行交换
                swap(chars, curi - 1, i);
                // 截断点之后的数字进行升序（本来为降序）
                swapAll(chars, i + 1, nStr.length() - 1);
                res = Long.parseLong(String.valueOf(chars));
                break;
            }
        }

        return res > Integer.MAX_VALUE || res < Integer.MIN_VALUE ? -1 : (int) res;
    }

    private static void swapAll(char[] chars, int start, int end) {
        while (start < end) {
            swap(chars, start, end);
            start++;
            end--;
        }
    }

    private static void swap(char[] chars, int start, int end) {
        char temp = chars[start];
        chars[start] = chars[end];
        chars[end] = temp;
    }

    public static void main(String[] args) {
        System.out.println(nextGreaterElement(12));
        System.out.println(nextGreaterElement(1999999999));
    }

}
