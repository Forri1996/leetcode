package org.fotech.leetcode;


import java.util.*;

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

        Queue<Integer> quee = new ArrayDeque<>();
        quee.offer(1);
        quee.offer(1);
        quee.offer(1);
        System.out.println(quee.size());


        int[][] input = {{1,1,0},{1,1,0},{0,0,1}};
        int[] initial = {0,1,2};
        System.out.println(minMalwareSpread(input, initial));;
    }

    public static int minMalwareSpread(int[][] input, int[] initial) {
        // 构建邻接表
        List<Set<Integer>> linjie = new ArrayList<>();
        for (int i =0; i < input.length; i++) {
            linjie.add(new HashSet<>());
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
        // 当感染节点数更小的时候，去掉的病毒节点
        int minItem = 0;
        int total = Integer.MAX_VALUE;
        for (int removed : initial) {
            // 已经感染的节点，默认是false
            boolean[] ganranNode = new boolean[input[0].length];
            Queue<Integer> queue = new ArrayDeque<>();
            // 广度优先算法，计算除掉removed后，剩下的init可以感染的总数
            int sum = 0;
            for (int ganran : initial) {
                if (ganran == removed) {
                    continue;
                }
                queue.offer(ganran);

                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    // 感染node节点，以及node节点的临界节点
                    // 如果已经被感染了就跳过
                    if (node == removed || ganranNode[node] == true) {
                        continue;
                    } else {
                        // 感染一个节点，数量加1
                        ganranNode[node] = true;
                        sum++;
                        linjie.get(node).forEach(queue::add);
                    }
                }
                if (sum < total) {
                    total = sum;
                    minItem = removed;
                }
            }
        }
        return minItem;
    }


}
