package org.fotech.leetcode;

/**
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4], k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6], k = 4
 * 输出: 4
 *
 * 用堆老实现
 * 方法二：基于堆排序的选择方法
 * 思路和算法
 *
 * 我们也可以使用堆排序来解决这个问题——建立一个大根堆，做 k−1 次删除操作后堆顶元素就是我们要找的答案。
 * 在很多语言中，都有优先队列或者堆的的容器可以直接使用，
 * 但是在面试中，面试官更倾向于让更面试者自己实现一个堆。
 * 所以建议读者掌握这里大根堆的实现方法，在这道题中尤其要搞懂「建堆」、「调整」和「删除」的过程。
 *
 * 友情提醒：「堆排」在很多大公司的面试中都很常见，不了解的同学建议参考《算法导论》或者大家的数据结构教材，一定要学会这个知识点哦！^_^
 *
 */
public class Solution215 {
    // 核心是利用快排。这边不单独实现了。
    public int findKthLargest(int[] nums, int k) {
        // 快速排序
        return quickSelect(nums, 0, nums.length-1, k);
    }

    // 寻找left～right区间中，第k大的那个
    public int quickSelect(int[] nums, int left, int right, int k) {
        if(left == right) return nums[k];

        int x = nums[left];
        int i = left - 1;
        int j = right + 1;
        do {
            i++;
        } while (nums[i] < x);

        do {
            j--;
        } while (nums[j] > x);
        if (i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        if (k <= j) return quickSelect(nums, left, j, k);
        return quickSelect(nums, j+1, right, k);
    }
}
