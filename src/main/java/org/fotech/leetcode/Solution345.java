package org.fotech.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution345 {
    public String reverseVowels(String s) {
        Set<String> yuanyin = new HashSet<String>();
        yuanyin.add("a");
        yuanyin.add("A");
        yuanyin.add("e");
        yuanyin.add("E");
        yuanyin.add("i");
        yuanyin.add("I");
        yuanyin.add("o");
        yuanyin.add("O");
        yuanyin.add("u");
        yuanyin.add("U");
        int start = 0;
        int end = s.length() - 1;
        char[] arr = s.toCharArray();
        while (start < end) {
            while (start <s.length()) {
                if (yuanyin.contains(String.valueOf(arr[start]))) {
                    break;
                } else {
                    start++;
                }
            }

            while (end >= 0) {
                if (yuanyin.contains(String.valueOf(arr[end]))) {
                    break;
                } else {
                    end--;
                }
            }

            if (start < end) {
                char m = arr[start];
                arr[start] = arr[end];
                arr[end] = m;
                start++;
                end--;
            }
        }

        return String.copyValueOf(arr);
    }

    public static void main(String[] args) {
        Solution345 solution345 = new Solution345();
        String a = solution345.reverseVowels("hello");
        System.out.println(a);
    }
}
