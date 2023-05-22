package org.fotech.bytedance;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class 最长不重复子串 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("anviaj"));
    }
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Set<Character> existString = new HashSet<>();
        existString.add(s.charAt(0));
        // 初始化第一个字符串
        // 左侧开始遍历
        int max = 1;
        for (int i = 0; i < s.length(); i++) {
            // 左侧开始移动，则移除掉exist里面存在的
            if (i > 0) {
                existString.remove(s.charAt(i - 1));
                existString.add(s.charAt(i));
            }


            // 右侧指针 这样右侧窗口重新滑了。实际上是不需要的。
            int j = i + 1;

            // 开始遍历右侧指针，如果exist中不存在，则一直往右边走
            while (j < s.length() && !existString.contains(s.charAt(j))) {
                existString.add(s.charAt(j));
                max = Math.max(max, j - i + 1);
                j++;
            }

        }

        return max;
    }
}
