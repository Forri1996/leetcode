package org.fotech.leetcode;

import java.util.HashMap;
import java.util.Map;

// todo un ac
// 前缀树
public class Solution560 {
    public static int calNum(int[] inputArr, int k) {
        int result = 0;
        int[] preSum = new int[inputArr.length];
        Map<Integer, Integer> preSumMap = new HashMap<>();
        int sum = 0;
        // 构建前缀和数组
        for (int i = 0; i < inputArr.length; i++) {
            sum += inputArr[i];
            preSum[i] = sum;
            preSumMap.put(sum, preSumMap.getOrDefault(sum, 0) + 1);
        }
        if (preSum[0] == k) {
            result++;
        }
        for (int i = 1; i < inputArr.length; i++) {
            result += preSumMap.getOrDefault(k-preSum[i], 0);
        }

        return result;
    }
}
