package org.fotech.leetcode;

/**
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 *
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 *
 * 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 */
public class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        // 先算左边的乘积
        int[] left = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                left[i] = 1;
            } else
            if (i == 1) {
                left[i] = nums[0];
            } else {
                left[i] = left[i-1] * nums[i-1];
            }
        }
        // 再算右边的乘积
        int[] right = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                right[i] = 1;
            } else
            if (i == nums.length - 2) {
                right[i] = nums[nums.length - 1];
            } else {
                right[i] = right[i+1] * nums[i+1];
            }
        }
        // 对应位置乘起来即可
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = left[i] * right[i];
        }

        return result;
    }

    public static void main(String[] args) {
        Solution238 solution238 = new Solution238();
        System.out.println(solution238.productExceptSelf(new int[]{-1,1,0,-3,3}));
    }
}
