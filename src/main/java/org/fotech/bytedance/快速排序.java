package org.fotech.bytedance;

import java.util.Arrays;

/**
 * 快速排序算法实现
 */
public class 快速排序 {
    public static void main(String[] args) {
        int[] nums = new int[5];
        nums[0] = 3;
        nums[1] = 5;
        nums[2] = 1;
        nums[3] = 2;
        nums[4] = 8;
        sort(nums, 0, 4);
        System.out.println(nums);
    }

    public static void sort(int[] nums, int start, int end) {
        // 递归终止的条件
        if (start > end) return;
        // 记录开始与结束的位置，方便遍历
        int i = start;
        int j = end;

        // 第一个对比的值，
        int base = nums[i];
        // 两个指针移动。把小的放在base左边，大的放到base右边
        while (i < j) {
            // 先找到比base小的位置
            while (i < j && nums[j] >= base) j--;
            // 在找到比base大的位置
            while (i < j && nums[i] <= base) i++;
            if (i < j) {
                // 交换两个位置
                swapNums(nums, i, j);
            }
        }
        // 最后一次，i=j。把第一个和对应的位置移动开。此时i的位置左侧都比base小，i的右侧都比base大
        swapNums(nums, start, i);
        // 递归左侧区间和右侧区间。
        sort(nums, start, j-1);
        sort(nums, i+1, end);
    }

    private static void swapNums(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


}
