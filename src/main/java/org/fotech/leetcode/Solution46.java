package org.fotech.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 *
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：[[1]]
 */
public class Solution46 {
    public static void main(String[] args) {
        Solution46 solution46 = new Solution46();
        int[] input = {1,2,3};
        System.out.println(solution46.permute(input));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> objects, int[] nums) {
        if (objects.size() == nums.length) {
            result.add(objects);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!objects.contains(nums[i])) {
                objects.add(nums[i]);
                backtrack(result, objects, nums);
                objects.remove(objects.size() - 1);
            }
        }
    }


}
