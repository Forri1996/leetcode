package org.fotech.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。

 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

 返回容器可以储存的最大水量。

 说明：你不能倾斜容器。
 */
public class Solution10 {
    public static void main(String[] args) {
        Solution10 solution10 = new Solution10();
        int[] input = new int[9];
        input[0] = 1;
        input[1] = 8;
        input[2] = 6;
        input[3] = 2;
        input[4] = 5;
        input[5] = 4;
        input[6] = 8;
        input[7] = 3;
        input[8] = 7;
        System.out.println(solution10.maxArea(input));
    }

    public int maxArea(int[] height) {
        int max = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            int size = (j - i) * Math.min(height[i], height[j]);
            if (size > max) {
                max = size;
            }
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }

        return max;
    }

    public int maxArea2(int[] height) {
        int max = 0;
        int maxHeight = 0;
        for (int i = 0; i < height.length - 1; i++) {
            if (height[i] > maxHeight) {
                maxHeight = height[i];
                for (int j = i+1; j < height.length; j++) {
                    // 计算i，j之间的面积，与最大值做比较
                    int size = (j - i) * Math.min(height[i], height[j]);
                    if (size > max) {
                        max = size;
                    }
                }
            }

        }

        return max;
    }

}
