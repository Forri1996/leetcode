package org.fotech.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个整数数组 nums 和一个整数 k 。
 *
 * 每一步操作中，你需要从数组中选出和为 k 的两个整数，并将它们移出数组。
 *
 * 返回你可以对数组执行的最大操作数。
 */
public class Solution1679 {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length-1;
        int res = 0;
        while (i < j) {
            if (nums[i] + nums[j] > k) {
                j--;
                continue;
            }
            if (nums[i] + nums[j] < k) {
                i++;
                continue;
            }
            if (nums[i] + nums[j] == k) {
                res++;
                i++;
                j--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution1679 solution1679 = new Solution1679();
        int[] nums = new int[]{2,5,4,4,1,3,4,4,1,4,4,1,2,1,2,2,3,2,4,2};
        int res = solution1679.maxOperations(nums, 3);
        System.out.println(res);
    }
}
