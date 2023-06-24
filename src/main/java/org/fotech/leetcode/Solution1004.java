package org.fotech.leetcode;

/**
 * 给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
 */
public class Solution1004 {

    public int longestOnes(int[] nums, int k) {
        // 左指针
        int left = 0;
        // 右指针
        int right = 0;
        // 用掉的0的个数。
        int zero = 0;
        int result = 0;
        // 右指针先行。碰到0的，且k还有余额，可以继续走。
        // 余额用完了，左指针走，一直走到余额充值
        while (right < nums.length) {

            if (nums[right] == 1) {
                result = Math.max(result, right - left + 1);
                right++;
                System.out.println("a left:"+left + "  right:" + right + "  zero:"+zero + "  result:"+result);
                continue;
            }
            if (nums[right] == 0) {
                // 还有余额
                if (zero < k) {
                    result = Math.max(result, right - left + 1);
                    right++;
                    zero++;
                    System.out.println("b left:"+left + "  right:" + right + "  zero:"+zero + "  result:"+result);
                } else {
                    // 没有余额了，左指针走，走到遇到的第二个0
                    while (true) {
                        if (nums[left] == 0) {
                            left++;
                            zero--;
                            break;
                        } else {
                            left++;
                        }
                        System.out.println("c left:"+left + "  right:" + right + "  zero:"+zero + "  result:"+result);
                    }
                    //System.out.println("left:"+left + "  right:" + right + "  zero:"+zero + "  result:"+result);
                }

            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution1004 solution1004 = new Solution1004();
        System.out.println(solution1004.longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
    }
}
