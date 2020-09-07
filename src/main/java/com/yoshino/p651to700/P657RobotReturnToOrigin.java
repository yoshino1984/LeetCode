package com.yoshino.p651to700;

/**
 * 机器人能否返回原点
 **/
public class P657RobotReturnToOrigin {

    public boolean judgeCircle(String moves) {
        int[] counter = new int[2];
        for (int i = 0; i < moves.length(); i++) {
            char ch = moves.charAt(i);
            if (ch == 'L') {
                counter[0]++;
            } else if (ch == 'R') {
                counter[0]--;
            } else if (ch == 'U') {
                counter[1]++;
            } else if (ch == 'D') {
                counter[1]--;
            }
        }

        return counter[0] == 0 && counter[1] == 0;
    }
}
