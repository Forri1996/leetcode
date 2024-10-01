package org.fotech.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution56 {

    public static void main(String[] args) {
        int[][] input = new int[][]{new int[]{1,3},new int[]{2,6},new int[]{8,10},new int[]{15,18}};
        Solution56 solution56 = new Solution56();
        System.out.println(solution56.collapse(input));
    }
    private int[][] collapse(int[][] input) {
        Arrays.sort(input, Comparator.comparingInt(o -> o[0]));


        List<int[]> result = new ArrayList<>();
        result.add(new int[]{input[0][0], input[0][1]});
        for (int i = 1; i < input.length; i++) {
            // 先判断左侧
            int currL = input[i][0];
            int currR = input[i][1];
            int n = result.size()-1;
            if (currL > result.get(n)[1]) {

                result.add(new int[]{currL, Math.max(currR, result.get(n)[1])});
            } else {
                result.get(n)[1] = Math.max(currR, result.get(n)[1]);
            }
        }


        return result.toArray(new int[result.size()][]);
    }
}
