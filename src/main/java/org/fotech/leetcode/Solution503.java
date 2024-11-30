package org.fotech.leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。
 *
 * 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * 示例 2:
 *
 * 输入: nums = [1,2,3,4,3]
 * 输出: [2,3,4,-1,4]
 */
public class Solution503 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] res = nextGreaterElements(input);
        System.out.println(res);
    }

    public static int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {

            int start = i + 1;
            if (i == nums.length - 1) {
                start = 0;
            }
            boolean flag = false;
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[start] > nums[i]) {
                    res[i] = nums[start];
                    flag = true;
                    break;
                } else {
                    if (start == nums.length - 1) {
                        start = 0;
                    } else {
                        start++;
                    }
                }
            }
            if (!flag) res[i] = -1;
        }

        return res;
    }
}
