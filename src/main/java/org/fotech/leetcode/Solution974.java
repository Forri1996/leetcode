package org.fotech.leetcode;

/**
 * 给定一个整数数组 nums 和一个整数 k ，返回其中元素之和可被 k 整除的非空 子数组 的数目。
 *
 * 子数组 是数组中 连续 的部分。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [4,5,0,-2,-3,1], k = 5
 * 输出：7
 * 解释：
 * 有 7 个子数组满足其元素之和可被 k = 5 整除：
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 * 示例 2:
 *
 * 输入: nums = [5], k = 9
 * 输出: 0
 *
 * 两个值除与k的的余数相同，则他们的差可以被k整除
 */
public class Solution974 {
    public static void main(String[] args) {
        int k = 5;
        int[] nums = {4,5,0,-2,-3,1};
        cal(nums, k);
    }

    public static void cal(int[] nums, int k) {
        int[] qianzhuihe = new int[nums.length];
        int sum = 0;
        for (int i = 0;i<nums.length; i++) {
            sum+=nums[i];
            qianzhuihe[i] = sum;
        }
        int count = 0;
        for (int i = 0; i < qianzhuihe.length; i++) {
            for (int j = i; j < qianzhuihe.length; j++) {
                if (i == j) {
                    if (qianzhuihe[i] % k == 0) {
                        count++;
                    }
                } else {
                    if (qianzhuihe[j] % k == qianzhuihe[i] % k) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
