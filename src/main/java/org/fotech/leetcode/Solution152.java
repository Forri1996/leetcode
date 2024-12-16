package org.fotech.leetcode;

/**
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续
 * 子数组
 * （该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 * 测试用例的答案是一个 32-位 整数。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: nums = [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */
public class Solution152 {
    /**
     * 记录已i为结尾的子数组的最大值即可
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        int[] dpMax = new int[nums.length];
        int[] dpMin = new int[nums.length];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        for (int i = 1; i< nums.length; i++) {
            dpMax[i] = Math.max(nums[i], Math.max(dpMax[i-1] * nums[i], dpMin[i-1]*nums[i]));
            dpMin[i] = Math.min(nums[i], Math.min(dpMax[i-1] * nums[i], dpMin[i-1]*nums[i]));
        }

        System.out.println(dpMax);
        System.out.println(dpMin);
    }
}
