package org.fotech.leetcode;

/**
 * 给你一个二进制数组 nums ，你需要从中删掉一个元素。
 *
 * 请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。
 *
 * 如果不存在这样的子数组，请返回 0 。
 *
 */
public class Solution1493 {
    public static int longestSubarray(int[] nums) {
        int start = 0;

        int max = 0;
        int zeroFlag = 0;
        while (start < nums.length) {
            if (start > 0 && nums[start] == 1 && nums[start - 1] != 0) {
                start++;continue;
            }
            int result = 0;
            int zeroLeft = 1;
            for (int i = start; i < nums.length; i++) {
                if (nums[i] == 1) {
                    result++;
                    continue;
                }
                if (nums[i] == 0) {
                    zeroFlag = 1;
                    if (zeroLeft == 1) {
                        zeroLeft--;
                    } else {
                        break;
                    }
                }
            }
            start++;
            if (max < result) {
                max = result;
            }
        }
        if (zeroFlag == 0) {
            max--;
        }

        return max;
    }

    public static void main(String[] args) {
        int[] input = {0,1,1,1,0,1,1,0,1};
        System.out.println(longestSubarray(input));
    }
}
