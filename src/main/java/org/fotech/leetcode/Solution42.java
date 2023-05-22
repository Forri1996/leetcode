package org.fotech.leetcode;

import java.util.Arrays;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，
 * 计算按此排列的柱子，下雨之后能接多少雨水。
 * https://leetcode.cn/problems/trapping-rain-water/?envType=study-plan-v2&id=top-100-liked
 */
public class Solution42 {
    public int trap(int[] height) {
        // 先计算整体的面积。
        // 然后减去柱子的面积。
        int sums = Arrays.stream(height).sum();
        int max = Arrays.stream(height).max().getAsInt();
        int total = 0;
        for (int i = 1; i <= max; i++) {
            int left = 0;
            int right = height.length - 1;
            while (left < height.length && height[left] < i) {
                left++;
            }
            while (right >= 0 && height[right] < i) {
                right--;
            }
            if (left > right) {
                continue;
            }
            total = total + (right - left + 1);
        }

        return total - sums;
    }

    public static void main(String[] args) {
        Solution42 solution42 = new Solution42();
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(solution42.trap(height));
    }
}
