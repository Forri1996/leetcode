package org.fotech.leetcode;

import java.util.*;

public class Solution649 {

    public String predictPartyVictory(String senate) {
        // 投票的轮次
        Queue<Integer> queD = new ArrayDeque<>();
        Queue<Integer> queR = new ArrayDeque<>();
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'D') {
                queD.add(i);
            } else {
                queR.add(i);
            }
        }

        while (!queD.isEmpty() && !queR.isEmpty()) {
            int rIndex = queR.poll();
            int dIndex = queD.poll();
            // 先投票的可以放到队尾，继续投票,后投票的被poll
            if (rIndex < dIndex) {
                queR.offer(rIndex + senate.length());
            } else {
                queD.offer(dIndex + senate.length());
            }
        }

        return !queR.isEmpty() ? "Radiant" : "Dire";
    }

    public static void main(String[] args) {
        Solution649 solution649 = new Solution649();
        System.out.println(solution649.predictPartyVictory("DDRRR"));
//        System.out.println(solution649.predictPartyVictory("RDD"));
//        System.out.println(solution649.predictPartyVictory("RD"));
//        System.out.println(solution649.predictPartyVictory("DR"));
    }
}
