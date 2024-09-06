package org.fotech.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution56 {
    private int[][] collapse(int[][] input) {
        Arrays.sort(input, Comparator.comparingInt(o -> o[0]));

        int maxL = input[0][0];
        int maxR = input[0][1];
        List<int[]> result = new ArrayList<>();
        for (int i = 1; i < input.length; i++) {
            int currL = input[i][0];
            int currR = input[i][1];

            // 区间合并，判断maxR是否要更新
            if (currL < maxR) {
                if (maxR < currR) {
                    maxR = currR;
                }
            } else {
                result.add(new int[]{maxL, maxR});
                maxL = currL;
                maxR = currR;
            }
        }
        if (result.size() == 0) {
            result.add(new int[]{maxL, maxR});
        }

        return result.toArray(new int[result.size()][]);
    }
}
