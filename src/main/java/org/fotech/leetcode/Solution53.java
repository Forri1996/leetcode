package org.fotech.leetcode;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 * [-2,1,-3,4,-1,2,1,-5,4]
 * [-2,1,-2,4,3,5,6,1,5]
 * 6
 */
public class Solution53 {

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        Solution53 s = new Solution53();
        System.out.println(s.maxSubArray(nums));
    }


    /**
     * 典型的动态规划
     * 定义dp[i] 为以 i 结尾的连续子数组的最长之和
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {

        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (dp[i-1] > 0) {
                dp[i] = dp[i-1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
        }


        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > res) {
                res = dp[i];
            }
        }

        return res;
    }


}
