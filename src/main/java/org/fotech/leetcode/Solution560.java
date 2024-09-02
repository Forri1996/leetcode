package org.fotech.leetcode;

import java.util.HashMap;
import java.util.Map;

// todo un ac
// 前缀树
public class Solution560 {
    /**
     * 前缀和
     * @param inputArr
     * @param k
     * @return
     */
    public int calNum(int[] inputArr, int k) {
        int result = 0;
        Map<Integer, Integer> preSumMap = new HashMap<>();
        preSumMap.put(0, 1);

        int sum = 0;
        // 构建前缀和数组
        for (int i = 0; i < inputArr.length; i++) {
            sum += inputArr[i];
            // 这里的判断要前置，因为判断的子串需要在左边
            if (preSumMap.containsKey(sum)) {
                result += preSumMap.get(sum);
            }
            preSumMap.put(sum, preSumMap.getOrDefault(sum, 0) + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution560 solution560 = new Solution560();
        int[] input = new int[]{1,2,3};
        solution560.calNum(input, 3);
    }
}
