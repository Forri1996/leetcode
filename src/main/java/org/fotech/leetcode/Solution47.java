package org.fotech.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * 示例 2：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 */
public class Solution47 {
    public static void main(String[] args) {
        Solution47 sol = new Solution47();
        int[] input = {1,1,2};
        System.out.println(sol.permuteUnique(input));
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        backtrack(result, new ArrayList<>(), nums, new HashSet<>());
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> objects, int[] nums, HashSet<Integer> cur) {
        if (objects.size() == nums.length) {
            if (!result.contains(objects)) {
                result.add(new ArrayList<>(objects));
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (cur.contains(i)) continue;
                objects.add(nums[i]);
                cur.add(i);
                backtrack(result, new ArrayList<>(objects), nums, cur);
                objects.remove(objects.size() - 1);
                cur.remove(i);
            }
        }
    }
}
