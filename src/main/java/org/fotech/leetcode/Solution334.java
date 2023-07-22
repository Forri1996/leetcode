package org.fotech.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。
 *
 * 如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。
 */
public class Solution334 {
    // 先找到两个元组，然后遍历后面的
    // 时间复杂度太高。
    // 暴力解
    public boolean increasingTriplet2(int[] nums) {
        Set<Integer> first = new HashSet<>();
//        Set<Integer> sec = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            Set<Integer> sec = new HashSet<>();
            if (first.contains(nums[i])) {
                continue;
            }
            first.add(nums[i]);
            for (int j = i+1; j < nums.length; j++) {
                if (sec.contains(nums[j])) {
                    continue;
                }
                sec.add(nums[j]);
                if (nums[j] > nums[i]) {
                    for (int k = j+1; k < nums.length; k++) {
                        if (nums[k] > nums[j]) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution334 solution334 = new Solution334();
        boolean a = solution334.increasingTriplet(new int[]{20,100,10,12,5,13});
        System.out.println(a);
    }

    public boolean increasingTriplet(int[] nums) {
        // 维护两个数组，leftmin和rightmax。
        int[] leftMin = new int[nums.length];
        leftMin[0] = nums[0];
        leftMin[1] = nums[0];
        int[] rightMax = new int[nums.length];
        rightMax[nums.length - 1] = nums[nums.length - 1];
        rightMax[nums.length - 2] = nums[nums.length - 1];
        for (int i = 2; i < nums.length; i++) {
            leftMin[i] = Math.min(nums[i-1], leftMin[i-1]);
        }

        for (int i = nums.length - 3; i >=0; i--) {
            rightMax[i] = Math.max(nums[i + 1], rightMax[i + 1]);
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > leftMin[i] && nums[i] < rightMax[i]) return true;
        }

        return false;
    }
}
