package org.fotech.bytedance;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 * 输入：grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 */
public class 岛屿数量 {

    public static void main(String[] args) {
        char[][] grid;
        grid = new char[4][5];
        grid[0] = new char[]{'0', '1', '1', '1', '0'};
        grid[1] = new char[]{'1', '1', '0', '1', '0'};
        grid[2] = new char[]{'1', '1', '0', '0', '0'};
        grid[3] = new char[]{'0', '0', '0', '0', '1'};
        岛屿数量 solution200 = new 岛屿数量();
        System.out.println(solution200.numIslands(grid));
    }


    // DFS 深度优先遍历。遍历过的设置为0。每进行一次深度遍历，则岛屿数量+1；
    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0) return 0;

        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    dfs(grid, i, j);
                }
            }
        }

        return result;
    }

    /**
     *
     * @param grid 整个棋盘
     * @param left 横向的位置
     * @param right 纵向的位置
     */
    public void dfs(char[][] grid, int left, int right) {
        // 超出边界
        if (
                left >= grid.length ||
                        left < 0 ||
                        right >= grid[0].length ||
                        right < 0
        ) return;
        if (grid[left][right] == '0') {
            return;
        }

        grid[left][right] = '0';

        dfs(grid, left+1, right);
        dfs(grid, left-1, right);
        dfs(grid, left, right+1);
        dfs(grid, left, right-1);

    }
}
