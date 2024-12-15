package org.fotech.leetcode;

public class Solution684 {
    public static void main(String[] args) {
        Solution684 solution684 = new Solution684();
        int[][] input = {{1,2},{2,3},{3,4},{4, 1},{5,1}};

        int[] parent = new int[100];
        // 每个结点的父结点是自己
        for (int i = 0; i<100; i++) {
            parent[i] = i;
        }
        for (int i = 0; i< input.length; i++) {
            int[] line = input[i];
            int node1 = line[0];
            int node2 = line[1];
            if (find(parent, node1) != find(parent, node2)) {
                union(parent, node1,node2);
            } else {
                // 两个结点父结点相同，那么就结束
                System.out.println(line);
                return;
            }
        }


    }

    private static void union(int[] parent, int node1, int node2) {
        parent[find(parent, node1)] = find(parent, node2);
    }

    private static int find(int[] parent, int node1) {
        if (parent[node1] == node1) {
            return node1;
        } else {
            return find(parent, parent[node1]);
        }
    }

}
