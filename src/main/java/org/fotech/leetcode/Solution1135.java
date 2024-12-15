package org.fotech.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 题目名称：最低成本联通所有城市
 * 题目内容：
 * 想象一下你是个城市基建规划者，有n个城市，城市编号从0到n - 1。给你一个大小为n - 1的数组connections，其中connections[i]=[xi, yi, costi]表示将城市xi和城市yi连接起来的成本为costi（连接是双向的）。
 * 你的任务是返回连通所有城市的最低成本。如果无法连通所有城市，返回 - 1。
 * 示例
 * 示例 1:
 * 输入：n = 3, connections = [[0,1,5],[1,2,7],[0,2,1]]
 * 输出：4
 * 解释：选择0 - 2和1 - 2这两条边，成本为1 + 3 = 4，可以连通所有城市。
 * 示例 2:
 * 输入：n = 4, connections = [[0,1,3],[1,2,7],[0,2,1],[0,3,2]]
 * 输出：3
 * 解释：选择0 - 3这条边，成本为2，再选择0 - 2这条边，成本为1，可以连通所有城市，总花费为3。
 * 限制条件
 * 1 <= n <= 10000
 * n - 1 <= connections.length <= 10000
 * 0 <= xi, yi <= n - 1
 * connections[i].length == 3
 * 1 <= costi <= 10000
 * xi!= yi
 *
 *
 * 构建并查集
 * 首先初始化，每个节点的parent是自己
 * 然后对数组进行排序，成本小的城市先联通
 */
public class Solution1135 {
    public static void main(String[] args) {
        int n = 3;
        int[][] input = {{0,1,5},{1,2,7},{0,2,1}};
        System.out.println(cal(n, input));
    }

    public static int cal(int n, int[][] input) {
        UnionArr unionArr = new UnionArr(n);
        Arrays.sort(input, Comparator.comparingInt(a -> a[2]));
        int score = 0;
        int lineNum = 0;
        for (int[] item : input) {
            if (unionArr.find(item[0]) != unionArr.find(item[1])) {
                // 两个城市不相连，则连接起来，并加上分数
                unionArr.union(item[0], item[1]);
                score += item[2];
                lineNum++;
                if (lineNum == n-1) {
                    return score;
                }
            }
        }
        return -1;
    }


    public static class UnionArr {
        private int[] parent;
        UnionArr(int n){
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int node) {
            if (parent[node] == node) {
                return node;
            }
            return find(parent[node]);
        }

        public void union(int node1, int node2) {
            int parent1 = find(node1);
            int parent2 = find(node2);
            if (parent1 != parent2) {
                parent[parent1] = parent2;
            }
        }
    }
}
