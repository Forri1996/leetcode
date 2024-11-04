package org.fotech.hot100;

import java.util.ArrayList;
import java.util.List;

public class Solution54 {
    public static void main(String[] args) {
        Solution54 solution54 = new Solution54();
        int[][] input = {{1,2,3,4,5,6},{7,8,9,10,11,12},{13,14,15,16,17,18}};
        System.out.println(solution54.rollMatrix(input));
    }

    private List<Integer> rollMatrix(int[][] input) {
        int left = 0;
        int right = input[0].length - 1;
        int top = 0;
        int bottom = input.length - 1;
        List<Integer> result = new ArrayList<>();
        while (left <= right && top <= bottom) {
            // 左到右，顶层减1
            for (int i = left; i <= right; i++) {
                result.add(input[top][i]);
            }
            top++;
            // 上到下
            for (int i = top; i <= bottom; i++) {
                result.add(input[i][right]);
            }
            right--;
            // 右到左
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(input[bottom][i]);
                }
            }
            bottom--;
            // 下到上
            if (left <= right) {
               for (int i = bottom; i >= top; i--) {
                   result.add(input[i][left]);
               }
           }
            left++;
        }

        return result;
    }
}
