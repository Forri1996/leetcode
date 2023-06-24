package org.fotech.leetcode;

import java.util.Stack;

public class Solution2390 {
    public String removeStars(String s) {
        Stack<String> st = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            String m = String.valueOf(s.charAt(i));
            if ("*".equals(m)) {
                st.pop();
            } else {
                st.push(m);
            }
        }
        String res = "";
        for (String m : st) {
            res += m;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution2390 solution2390 = new Solution2390();
        System.out.println(solution2390.removeStars("leet**cod*e"));
    }
}
