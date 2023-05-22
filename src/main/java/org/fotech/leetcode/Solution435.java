package org.fotech.leetcode;

import java.util.Arrays;

public class Solution435 {

    public static void main(String[] args) {
        Solution435 solution435 = new Solution435();

    }


    public int eraseOverlapIntervals(int[][] intervals) {
        // 先按照右端点排序
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        // 遍历，新的左断电大雨前一个右端点，就加入
        int n = 0;
        int maxRight = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= maxRight) {
                n++;
                maxRight = intervals[i][1];
            }
        }

        return intervals.length - n;
    }
}
