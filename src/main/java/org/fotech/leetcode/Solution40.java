package org.fotech.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 *
 * 注意：解集不能包含重复的组合。
 *
 *
 *
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 */
public class Solution40 {
    public static void main(String[] args) {
        int[] input = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combinationSum(input, target));
    }

    public static List<List<Integer>> combinationSum(int[] input, int target) {
        Arrays.sort(input);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), input, target, -1);

        return result;
    }

    private static  void backtrack(List<List<Integer>> result, List<Integer> es, int[] input, int remain, int start) {
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            if (!result.contains(es)) {
                result.add(new ArrayList<>(es));
            }
        } else {
            for (int i = start+1; i < input.length; i++) {

                es.add(input[i]);
                backtrack(result, es, input, remain-input[i], i);
                es.remove(es.size()-1);
            }
        }
    }

}
