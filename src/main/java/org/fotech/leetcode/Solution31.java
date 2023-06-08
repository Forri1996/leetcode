package org.fotech.leetcode;

/**
 * 整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
 *
 * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，
 * 如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，
 * 那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。
 * 如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 *
 * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
 * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
 * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
 * 给你一个整数数组 nums ，找出 nums 的下一个排列。
 *
 * 必须 原地 修改，只允许使用额外常数空间。
 */
public class Solution31 {
    public void nextPermutation(int[] nums) {
        // 从后往前遍历，找到第一个i，j，其中nums[i] < nums[j]
        boolean flag = false;
        for (int i = nums.length - 2; i >=0; i--) {
            if (nums[i] < nums[i + 1]) {
                // 从j 到 nums.size 范围内，找到第一个大于 nums[i] 的位置 k
                for (int k = nums.length - 1; k >= i+1; k--) {
                    // 交换 i 和 k的位置
                    if (nums[k] > nums[i]) {
                        int tmp = nums[k];
                        nums[k] = nums[i];
                        nums[i] = tmp;
                        // 翻转 i 后面的值。
                        // 逆转[i,end]的排列顺序
                        int start = i + 1;
                        int end = nums.length - 1;
                        while (start < end) {
                            tmp = nums[start];
                            nums[start] = nums[end];
                            nums[end] = tmp;
                            start++;
                            end--;
                        }
                        return;
                    }
                }
            }
        }
        if (!flag) {
            int start = 0;
            int end = nums.length - 1;
            while (start < end) {
                int tmp = nums[start];
                nums[start] = nums[end];
                nums[end] = tmp;
                start++;
                end--;
            }
        }
    }

    public static void main(String[] args) {
        Solution31 solution31 = new Solution31();
        int[] input = new int[]{1,2,3};
        solution31.nextPermutation(input);
        System.out.println(input);
    }
}
