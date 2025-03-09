package org.fotech.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 */
public class Solution54 {
    public static void main(String[] args) {
        int[][] input = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        Solution54 solution54 = new Solution54();
        solution54.spiralOrder(input);
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        // 右，下，左，上
        int[][] direction = {{0,1},{1,0},{0,-1},{-1, 0}};
        int[][] hasBeenHere = new int[matrix.length][matrix[0].length];
        List<Integer> result = new ArrayList<>();
        int start = 0;
        int currL = 0;
        int currR = -1;
        while (true) {
            if (result.size() == matrix.length * matrix[0].length) {
                return result;
            }
            // 走一步
            currL = currL + direction[start][0];
            currR = currR + direction[start][1];

            // 超出界限，或者走到已经走过的地方，则反方向走一步,然后拐弯
            if (currL >= matrix.length || currL < 0 || currR < 0 || currR >= matrix[0].length ||
                    hasBeenHere[currL][currR] == 2) {

                currL = currL - direction[start][0];
                currR = currR - direction[start][1];
                start = (start+1)%4;
                continue;
            }

            result.add(matrix[currL][currR]);
            hasBeenHere[currL][currR] = 2;
        }
    }
}
