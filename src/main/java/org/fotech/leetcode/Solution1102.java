package org.fotech.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个R行C列的整数矩阵A，从左上角[0,0]出发，需要在右下角[R-1,C-1]结束。
 * 路径只能沿四个基本方向（上、下、左、右）移动，
 * 即从一个已访问的单元格移动到相邻的任一未访问单元格。
 * 路径的得分定义为路径上所有数字中的最小值。要求找出所有路径中得分最高的那条路径，并返回其得分。
 *
 * 例如：
 *
 * 示例1: 输入: [[5,4,5],[1,2,6],[7,4,6]]。得分最高的路径会被突出显示，但在此文字描述中无法直接显示。
 * 示例2: 输入: [[2,2,1,2,2,2],[1,2,2,2,1,2]]。输出: 2。
 * 示例3: 输入: [[3,4,6,3,4],[0,2,1,1,7],[8,8,3,2,7],[3,2,4,9,8],[4,1,2,0,0],[4,6,5,4,3]]。输出: 3。
 *
 * 找到4个方向中，分最少的一条路，走过去
 * 走过的路径不需要再走。
 * 用一个queue存下一步走过的位置
 * 用一个matrix存每个位置的路径的最小值
 * 用一个maxScore存最大值结果
 */
public class Solution1102 {
    // 定义四个方向
    private static int[][] direction = {{0,1},{1,0},{0,-1},{-1,0}};

    public static void main(String[] args) {
        int[][] input = {{3,4,6,3,4},{0,2,1,1,7},{8,8,3,2,7},{3,2,4,9,8},{4,1,2,0,0},{4,6,5,4,3}};
        int[][] matrix = new int[input.length][input[0].length];
        int maxScore = 0;

        Queue<int[]> queue = new LinkedList<>();
        // 出发点
        int[] first = {0,0, input[0][0]};
        // 站过的地方，设置为1
        matrix[0][0] = 1;

        queue.add(first);

        while (!queue.isEmpty()) {
            int[] currPoint = queue.poll();
            int x = currPoint[0];
            int y = currPoint[1];

            matrix[x][y] = 1;
            maxScore = Math.max(maxScore, currPoint[2]);

            // 遍历4个方向，加到queue里
            for (int[] dir : direction) {
                int nextX = x + dir[0];
                int nextY = y + dir[1];
                if (nextY < 0 || nextX < 0 || nextX >=input.length || nextY >= input[0].length) {
                    continue;
                }
                if (matrix[nextX][nextY] == 1) {
                    continue;
                }

                int[] item = {nextX, nextY,  Math.min(input[nextX][nextY], currPoint[2])};
                queue.add(item);
            }
        }

        System.out.println(maxScore);
    }
}
