package com.yoshino.p1201to1300;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 力扣排行榜
 **/
public class P1244DesignALeaderboard {

}

class Leaderboard {

    private int[][] playerScore;
    private Set[] scorePlayer;

    public Leaderboard() {
        playerScore = new int[12000][2];
        scorePlayer = new Set[10000];
        for (int i = 0; i < scorePlayer.length; i++) {
            scorePlayer[i] = new HashSet<Integer>();
        }
    }

    public void addScore(int playerId, int score) {
        if (playerScore[playerId][0] == 1) {
            int oldScore = playerScore[playerId][1];
            scorePlayer[oldScore].remove(playerId);
            score += oldScore;
        } else {
            playerScore[playerId][0] = 1;
        }
        scorePlayer[score].add(playerId);
        playerScore[playerId][1] = score;
    }

    public int top(int K) {
        int total = 0;
        for (int i = scorePlayer.length - 1; i >= 0; i--) {
            int count = Math.min(scorePlayer[i].size(), K);
            K -= count;
            total += i * count;
            if (K == 0) {
                break;
            }
        }
        return total;
    }

    public void reset(int playerId) {
        playerScore[playerId][0] = 0;
        scorePlayer[playerScore[playerId][1]].remove(playerId);
    }
}

