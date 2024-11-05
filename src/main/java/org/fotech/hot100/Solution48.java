package org.fotech.hot100;

public class Solution48 {

    /**
     * m[i][j] -> m[j][n-1-i]
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int[][] tmp = new int[matrix.length][matrix[0].length];
        int n = matrix.length;
        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < tmp[i].length; j++) {
                tmp[i][j] = matrix[j][n - 1 - i];
            }
        }
        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < tmp[i].length; j++) {
                matrix[i][j] = tmp[i][j];
            }
        }
    }
}
