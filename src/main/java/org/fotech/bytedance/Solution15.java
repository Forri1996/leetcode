package org.fotech.bytedance;

import java.util.*;

/**
 * 你一个整数数组 nums ，
 * 判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * <p>
 * 你返回所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 */
public class Solution15 {

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        // 先转成一个map 如果map.contains 则有。
        Map<Integer, List<Integer>> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numsMap.containsKey(nums[i])) {
                numsMap.get(nums[i]).add(i);
            } else {
                List<Integer> val = new ArrayList<>();
                val.add(i);
                numsMap.put(nums[i], val);
            }
        }

        List<List<Integer>> result = new ArrayList<>();


        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                    continue;
                }
                if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                    continue;
                }
                if (nums[i] + nums[j] + nums[k] == 0 ) {
                    if (j > i + 1 && nums[j] == nums[j-1]) {
                        j++;
                        continue;
                    }
                    if (k < nums.length - 1 && nums[k] == nums[k+1]) {
                        k--;
                        continue;
                    }
                    List<Integer> resItem = new ArrayList<>();
                    resItem.add(nums[i]);
                    resItem.add(nums[j]);
                    resItem.add(nums[k]);
                    result.add(resItem);
                    j++;
                }

            }

//
//            for (int j = i + 1; j < nums.length - 1; j++) {
//                if (j > i+1 && nums[j] == nums[j-1]) {
//                    continue;
//                }
//                int compared = -nums[i] - nums[j];
//                int k = nums.length - 1;
//                while (k > j && nums[k] >= compared) {
//                    if (nums[k] == compared) {
//                        List<Integer> resItem = new ArrayList<>();
//                        resItem.add(nums[i]);
//                        resItem.add(nums[j]);
//                        resItem.add(nums[k]);
//                        result.add(resItem);
//                        break;
//                    }
//                    k--;
//                }
//
//            }
        }

        return result;
    }
}
