package org.fotech.leetcode;

public class Solution73 {
    public void setZeroes(int[][] matrix) {

        int[][] zero = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                if (matrix[i][j] == 0) {
                    // 计算出所有需要设置成 0 的元素，并将元素下表存储下来
                    int tmpI = i;
                    while (tmpI >= 0) {
                        zero[tmpI][j] = 1;
                        tmpI--;
                    }
                    tmpI = i;
                    while (tmpI < matrix.length) {
                        zero[tmpI][j] = 1;
                        tmpI++;
                    }

                    int tmpJ = j;
                    while (tmpJ >= 0) {
                        zero[i][tmpJ] = 1;
                        tmpJ--;
                    }
                    tmpJ = j;
                    while (tmpJ < matrix[0].length) {
                        zero[i][tmpJ] = 1;
                        tmpJ++;
                    }
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (zero[i][j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution73 solution73 = new Solution73();
        int[][] zero = new int[3][3];
        zero[0][0] = 1;
        zero[0][1] = 1;
        zero[0][2] = 1;
        zero[1][0] = 1;
        zero[1][1] = 0;
        zero[1][2] = 1;
        zero[2][0] = 1;
        zero[2][1] = 1;
        zero[2][2] = 1;
        solution73.setZeroes(zero);
        System.out.println(zero);
    }

}
