package org.fotech.hot100;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution239 {
    public static void main(String[] args) {
        Solution239 solution239 = new Solution239();
        System.out.println(solution239.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1];
            }
        });
        /**
         * 记录优先队列的最大值和位置。
         * 向右移动窗口，判断最大值是否在窗口内，如果在窗口内，最大值不变，否则poll后判断下一个最大值是否在窗口内
         */
        for (int i = 0; i < k; i++) {
            priorityQueue.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = priorityQueue.peek()[0];

        for (int i = k; i < n; i++) {
            priorityQueue.offer(new int[]{nums[i], i});
            while (priorityQueue.peek()[1] <= (i-k)) {
                priorityQueue.poll();
            }

            ans[i-k+1] = priorityQueue.peek()[0];
        }

        return ans;
    }

    // 时间复杂度太高
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int left = 0;
        int right = k-1;
        int[] output = new int[nums.length-k+1];
        if (k == 1) {
            return nums;
        }
        while (right < nums.length) {
            if (left == 0) {
                output[left] = this.getMax(nums, left, right);
            } else {
                // 如果左边少掉的这个元素是最大值，则重新计算
                // 如果右边新的元素大于最大值，则直接赋值
                // 其他情况，和上一个值相等
                if (nums[left - 1] == output[left - 1]) {
                    output[left] = getMax(nums, left, right);
                } else if (nums[right] > output[left - 1]) {
                    output[left] = nums[right];
                } else {
                    output[left] = output[left - 1];
                }
            }
            left++;
            right++;
        }

        return output;
    }

    private int getMax(int[] input, int left, int right) {
        int max = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            if (input[i] > max) {
                max = input[i];
            }
        }

        return max;
    }
}
