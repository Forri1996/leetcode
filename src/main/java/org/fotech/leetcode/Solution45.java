package org.fotech.leetcode;

/**
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 *
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 *
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 */
public class Solution45 {
    // 应该是从后往前遍历
    public int jump(int[] nums) {
        int result = 0;
        int curr = nums.length - 1;
        while (curr > 0) {
            for (int i = 0; i < curr; i++) {
                if (i + nums[i] >= curr) {
                    curr = i;
                    result++;
                    break;
                }
            }
        }

        return result;
    }

    // 这个算法有问题。错误的用例：[10,9,8,7,6,5,4,3,2,1,1,0]
    public int jump2(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int curr = 0;
        int result = 0;

        while (curr < nums.length) {
            int max = -1;
            int maxIndex = 0;

            if (curr + 1 + nums[curr] >= nums.length) {
                result++;
                break;
            }

            for (int i = curr+1; i < curr + 1 + nums[curr]; i++) {
                if (nums[i] >= max) {
                    max = nums[i];
                    maxIndex = i;
                }
            }
            curr = maxIndex;
            result++;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution45 solution45 = new Solution45();
        System.out.println(solution45.jump(new int[]{10,9,8,7,6,5,4,3,2,1,1,0}));
    }
}
