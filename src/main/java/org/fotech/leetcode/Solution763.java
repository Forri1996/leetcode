package org.fotech.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
 *
 * 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
 *
 * 返回一个表示每个字符串片段的长度的列表。
 *
 *
 *
 * 示例 1：
 * 输入：s = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca"、"defegde"、"hijhklij" 。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 这样的划分是错误的，因为划分的片段数较少。
 * 示例 2：
 *
 * 输入：s = "eccbbbbdec"
 * 输出：[10]
 */
public class Solution763 {
    public static void main(String[] args) {

//        String s = "ababcbacadefegdehijhklij";
        String s = "eccbbbbdec";
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            String item = String.valueOf(s.charAt(i));
            map.put(item, i);
        }
        List<Integer> res = new ArrayList<>();
        int max = -1;
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            String item = String.valueOf(s.charAt(i));
            // 获取到当前字符的最大
            int itemMax = map.get(item);
            if (itemMax > end) {
                end = itemMax;
            }
            // 找到一个片段
            if (end == i) {

                res.add(i-start+1);
                start = i+1;
                if (i != s.length() - 1) {
                    end =  map.get(String.valueOf(s.charAt(i+1)));
                }
            }

        }

        System.out.println(res);
    }
}
