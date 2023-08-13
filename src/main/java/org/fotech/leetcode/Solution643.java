package org.fotech.leetcode;

import java.util.Arrays;

/**
 * 给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
 *
 * 请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
 *
 * 任何误差小于 10-5 的答案都将被视为正确答案。
 */
public class Solution643 {
    public double findMaxAverage(int[] nums, int k) {
        int[] total = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            total[0] += nums[i];
        }
        int j = 1;
        for (int i = k; i < nums.length; i++) {
            int tmpTotal = total[j - 1] - nums[i - k] + nums[i];
            total[j] = tmpTotal;
            j++;
        }

        return (double) Arrays.stream(total).max().getAsInt() / k;
    }

    public static void main(String[] args) {
        Solution643 solution643 = new Solution643();
        int[] nums = {0,4,0,3,2};
        solution643.findMaxAverage(nums, 1);
    }
}
