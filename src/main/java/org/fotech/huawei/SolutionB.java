package org.fotech.huawei;

import java.util.Scanner;

public class SolutionB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lines = sc.nextInt();
        int items = sc.nextInt();
        int[][] matrix = new int[lines][items];

        // 初始化坐标
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < items; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int[][] result = new int[lines][items];
        for (int i = 0; i < lines; i++) {
            int[] item = new int[items];
            for (int j = 0; j < items; j++) {
                item[j] = find(i, j, matrix[i][j], matrix);
            }
            result[i] = item;
        }
        String resultStr = "";
        for (int i = 0; i < result.length; i++) {
            if (i == 0) {
                resultStr +="[";
            }

            for (int j = 0; j < result[0].length; j++) {
                if (j == 0) {
                    resultStr = resultStr + "[" + result[i][j] + ", ";
                } else if ( j == result[0].length - 1) {
                    if (i == result.length - 1) {
                        resultStr = resultStr + result[i][j] + "]";
                    } else {
                        resultStr = resultStr + result[i][j] + "], ";
                    }

                } else {
                    resultStr = resultStr + result[i][j] + ", ";
                }

            }

            if (i == result.length - 1) {
                resultStr += "]";
            }
        }

        System.out.println(resultStr);
    }

    // 在数组中找最近的一个元素，如果有则返回距离，如果没有则返回-1
    private static int find(int matrixI, int matrixJ, int matrix, int[][] target) {
        int min = -1;

        for (int i = 0; i < target.length; i++) {
            for (int j = 0; j < target[0].length; j++) {
                if (matrixI == i && matrixJ == j) {
                    continue;
                }
                int length = cal(matrixI, matrixJ, i, j);
                if (target[i][j] == matrix) {
                    if (min == -1) {
                        min = length;
                    }
                    if (min > length) {
                        min = length;
                    }
                }
            }
        }


        return min;
    }

    // 计算两个位置的距离
    private static int cal(int matrixI, int matrixJ, int i, int j) {
        int a = i - matrixI;
        a = a < 0 ? -a : a;

        int b = j - matrixJ;
        b = b < 0 ? -b : b;

        return a + b;
    }
}
