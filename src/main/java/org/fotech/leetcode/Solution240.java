package org.fotech.leetcode;

public class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 缩小方阵
        int n = 0;
        int m = 0;

        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == target) return true;
            if (i == 0) continue;
            if (i == matrix[0].length - 1) {
                n = i;
            }
            if (matrix[0][i] > target && matrix[0][i-1] < target) {
                n = i;
                break;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == target) return true;
            if (i == 0) continue;
            if (i == matrix.length - 1) {
                m = i;
            }
            if (matrix[i][0] > target && matrix[i-1][0] < target) {
                m = i;
                break;
            }
        }
        for (int i = 0; i < m+1; i++) {
            for (int j = 0; j < n+1; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,4,7,11,15};
        int[] b = new int[]{2,5,8,12,19};
        int[] c = new int[]{3,6,9,16,22};
        int[] d = new int[]{10,13,14,17,24};
        int[] e = new int[]{18,21,23,26,30};
        int[][] input = new int[][]{a,b,c,d,e};
        Solution240 solution240 = new Solution240();
        System.out.println(solution240.searchMatrix(new int[][]{
                {1,4},
                {2,5}

        }, 5));
    }
}
