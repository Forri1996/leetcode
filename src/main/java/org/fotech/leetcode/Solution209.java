package org.fotech.leetcode;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其总和大于等于 target 的长度最小的
 * 子数组
 *  [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 示例 2：
 *
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 *
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 *
 * 滑动窗口，滑到left=right=length的时候返回结果
 */
public class Solution209 {
    public static void main(String[] args) {
        int target = 11;
        int[] nums = {1,1,1,1,1,1,1,1};
        int left = 0;
        int right = 0;
        int minSize = 0;
        while (left <= right && left < nums.length) {
            int sum = 0;
            for (int i = left; i <= right; i++) {
                sum += nums[i];
            }
            if (sum < target) {
                if (right < nums.length-1) {
                    right++;
                } else {
                    left++;
                }
            } else {
                if (minSize == 0) {
                    minSize = right-left+1;
                } else {
                    minSize = Math.min(minSize, right-left+1);
                }
                left++;
            }
        }
        System.out.println(minSize);
    }
}
