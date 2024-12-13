package org.fotech.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目名称
 * 尽量减少恶意软件的传播
 * 题目描述
 * 在一个网络中，节点从 0 到 n - 1 编号，有一个初始的恶意软件节点列表 initial，当一个节点被恶意软件感染时，
 * 它会感染它的邻居节点。网络的连接关系通过一个 graph 矩阵表示，
 * 其中 graph[i][j] 等于 1 表示节点 i 和节点 j 之间有连接，等于 0 表示没有连接。
 * 目标是移除一个节点（该节点必须在 initial 列表中），使得最终被感染的节点数量最小。
 * 如果有多个节点可以达到相同的最小感染节点数，返回最小的节点编号。
 * 示例
 * 输入：graph = [[1,1,0],[1,1,0],[0,0,1]], initial = [0,1]
 * 输出：0
 * 解释：如果移除节点 0，只有节点 1 会被感染；如果移除节点 1，节点 0 会被感染；所以移除节点 0 更好，因为节点 0 的编号更小。
 *
 * 1、构建邻接表。即一个List<List<Integer>> 表示每个节点相邻的节点
 * 2、使用bfs计算移除一个节点后
 */
public class Solution924 {
    public static void main(String[] args) {
        int[][] input = {{1,1,0},{1,1,0},{0,0,1}};
        int[] initial = {0,1};
        // 构建邻接表
        List<List<Integer>> linjie = new ArrayList<>();
        for (int i =0; i < input.length; i++) {
            linjie.add(new ArrayList<>());
        }
        for (int i =0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                if (input[i][j] == 1) {
                    linjie.get(i).add(j);
                    linjie.get(j).add(i);
                }
            }
        }
        // 已经感染的节点
        // 循环感染节点
        for (int removed : initial) {
            boolean[] ganranNode = new boolean[input[0].length];
//            int num = cal(removed, initial,linjie);
        }
    }
}
