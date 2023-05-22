package org.fotech.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 */
public class Solution17 {

    // 用一个HashMap存储每个数字对应的字母列表
    public List<String> letterCombinations(String digits) {
        Map<Character, String> initMap = new HashMap<>();
        initMap.put('1', "");
        initMap.put('2', "abc");
        initMap.put('3', "def");
        initMap.put('4', "ghi");
        initMap.put('5', "jkl");
        initMap.put('6', "mno");
        initMap.put('7', "pqrs");
        initMap.put('8', "tuv");
        initMap.put('9', "wxyz");

        // 用一个ArrayList存储最终的结果
        List<String> result = new ArrayList<>();
        // 如果输入为空，直接返回空列表
        if (digits == null || digits.length() == 0) {
            return result;
        }
        // 调用回溯算法，从第0个数字开始处理
        backtrack(result, initMap, digits, 0, new StringBuffer());
        return result;
    }

    /**
     * 回溯算法
     *
     * @param combinations 结果数组。
     * @param phoneMap 初始化map。数字对应的字母列表
     * @param digits 输入的数字字符串
     * @param index 当前处理的数字索引
     * @param combination 当前的组合
     */
    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        // 如果处理完了所有数字，把当前组合加入结果数组，并返回
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            // 获取当前数字对应的字母列表
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            // 遍历每个字母
            for (int i = 0; i < lettersCount; i++) {
                // 把字母加入当前组合
                combination.append(letters.charAt(i));
                // 递归地处理下一个数字
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                // 回溯时删除最后一个字母
                combination.deleteCharAt(index);
            }
        }
    }


    public List<String> letterCombinations2(String digits) {
        Map<Character, String> initMap = new HashMap<>();
        initMap.put('1', "");
        initMap.put('2', "abc");
        initMap.put('3', "def");
        initMap.put('4', "ghi");
        initMap.put('5', "jkl");
        initMap.put('6', "mno");
        initMap.put('7', "pqrs");
        initMap.put('8', "tuv");
        initMap.put('9', "wxyz");

        List<String> result = new ArrayList<>();

        for (int i = 0; i < digits.length(); i++) {
            String s = initMap.get(digits.charAt(i));
            if (result.size() == 0) {
                for (int j = 0; j < s.length(); j++) {
                    result.add(String.valueOf(s.charAt(j)));
                }
            } else {
                List<String> temp = new ArrayList<>();
                for (int j = 0; j < result.size(); j++) {
                    for (int k = 0; k < s.length(); k++) {
                        temp.add(result.get(j) + s.charAt(k));
                    }
                }
                result = temp;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution17 s = new Solution17();
        System.out.println(s.letterCombinations("23"));
    }
}
