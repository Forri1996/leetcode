package org.fotech.leetcode;

import org.fotech.bytedance.ListNode;

public class Solution2130 {
    public int pairSum(ListNode head) {
        int[] nums = new int[100];
        int i = 0;
        while (head != null) {
            nums[i] = head.val;
            i++;
            head = head.next;
        }
        if (i == 2) {
            return nums[0] + nums[1];
        }
        int max = 0;
        for (int m = 0; m < i/2 - 1; m++) {
            if (nums[m] + nums[i - 1 - m] > max) {
                max = nums[m] + nums[i - 1 - m];
            }
        }

        return max;
    }
}
