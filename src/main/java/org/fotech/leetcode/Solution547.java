package org.fotech.leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 *
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 *
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
 *
 * 返回矩阵中 省份 的数量。
 *
 * 解法：深度优先遍历，以一个城市出发，把其他所有城市访问状态都标记成1
 */
public class Solution547 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] first = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] matrix = new int[first.length][first.length];
        matrix[0] = first;
        for (int i = 1; i < first.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int res = findCircleNum(matrix);
        System.out.println(res);
    }

    public static int findCircleNum(int[][] isConnected) {
        int province = 0;
        int cityNum = isConnected.length;
        int[] visited = new int[cityNum];

        for (int i = 0; i < cityNum; i++) {
            if (visited[i] == 0) {
                dfs(i, isConnected, visited, cityNum);
                province++;
            }
        }

        return province;
    }

    private static void dfs(int i, int[][] isConnected, int[] visited, int cityNum) {
        for (int j = 0; j < cityNum; j++) {
            if (isConnected[i][j] == 1 && visited[j] != 1) {
                visited[j] = 1;
                dfs(j, isConnected, visited, cityNum);
            }
        }
    }
}
