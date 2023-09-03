package org.fotech.leetcode;

import java.util.*;

/**
 * 给你一个下标从 0 开始、大小为 n x n 的整数矩阵 grid ，返回满足 Ri 行和 Cj 列相等的行列对 (Ri, Cj) 的数目。
 *
 * 如果行和列以相同的顺序包含相同的元素（即相等的数组），则认为二者是相等的。
 * 示例 1：
 *
 *
 *
 * 输入：grid = [[3,2,1],[1,7,6],[2,7,7]]
 * 输出：1
 * 解释：存在一对相等行列对：
 * - (第 2 行，第 1 列)：[2,7,7]
 * 示例 2：
 *
 *
 *
 * 输入：grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]
 * 输出：3
 * 解释：存在三对相等行列对：
 * - (第 0 行，第 0 列)：[3,1,2,2]
 * - (第 2 行, 第 2 列)：[2,4,2,2]
 * - (第 3 行, 第 2 列)：[2,4,2,2]
 *
 */
public class Solution2352 {

    public int equalPairs(int[][] grid) {
        List<String> hangArr = new ArrayList<>();

        List<String> lieArr = new ArrayList<>();
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            String hang = changeArrToDig(grid, i, 0);
            String lie = changeArrToDig(grid, i, 1);
            hangArr.add(hang);
            lieArr.add(lie);
        }

        for (String integer : hangArr) {
            for (String value : lieArr) {
                if (Objects.equals(integer, value)) res++;
            }
        }

        return res;
    }

    /**
     * 把某一列或者某一行变成一个数字
     *
     * @param grid
     * @param i
     * @param flag
     * @return
     */
    public String changeArrToDig(int[][] grid, int m, int flag) {
        StringBuilder res = new StringBuilder();
        // 计算列
        if (flag == 1) {
            for (int i = 0; i < grid.length; i++) {
                res.append(grid[i][m]).append(",");
            }
        } else {
            for (int i = 0; i < grid.length; i++) {
                res.append(grid[m][i]).append(",");
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        Solution2352 solution2352 = new Solution2352();
//        int[][] grid = {{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}};
        int[][] grid = {{2,30,400},{40,7,6},{300,7,7}};
//        int[][] grid = {{13,13},{13,13}};
        System.out.println(solution2352.equalPairs(grid));
    }
}
