package org.fotech.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 题目描述
 Linux操作系统有多个发行版，distrowatch.com提供了各个发行版的资料。这些发行版互相存在关联，例如Ubuntu基于Debian开发，而Mint又基于Ubuntu开发，那么我们认为Mint同Debian也存在关联。

 发行版集是一个或多个相关存在关联的操作系统发行版，集合内不包含没有关联的发行版。

 给你一个 n * n 的矩阵 isConnected，其中 isConnected[i][j] = 1 表示第 i 个发行版和第 j 个发行版直接关联，而 isConnected[i][j] = 0 表示二者不直接相连。

 返回最大的发行版集中发行版的数量。

 输入描述
 第一行输入发行版的总数量N，

 之后每行表示各发行版间是否直接相关

 输出描述
 输出最大的发行版集中发行版的数量
 */
public class Homework21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer num = Integer.parseInt(sc.nextLine());
        Integer[][] input = new Integer[num][num];
        for (int i = 0; i < num; i++) {
            Integer[] row = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            input[i] = row;
        }

        Integer[] dp = new Integer[num];
        for (int i = 0; i < num; i++) {
            dp[i] = i;
        }

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (input[i][j] == 1 || find(i, dp) == find(j, dp)) {
                    union(i, j, dp);
                }
            }
        }
        for (int i = 0; i < num; i++) {
            dp[i] = find(i, dp);
        }
        System.out.println(dp);
    }

    private static Integer find(int i, Integer[] dp) {
        if (dp[i] != i) {
            return find(dp[i], dp);
        }
        return i;
    }
    private static void union(int i, int j, Integer[] dp) {
        if (find(i, dp) != find(j, dp)) {
            dp[i] = find(j, dp);
        }
    }
}
