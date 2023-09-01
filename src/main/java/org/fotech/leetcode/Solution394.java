package org.fotech.leetcode;

import org.apache.commons.lang3.StringUtils;

import java.util.Stack;

/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * 示例 2：
 *
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * 示例 3：
 *
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 * 示例 4：
 *
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"

 提示：

 1 <= s.length <= 30
 s 由小写英文字母、数字和方括号 '[]' 组成
 s 保证是一个 有效 的输入。
 s 中所有整数的取值范围为 [1, 300]

 */
public class Solution394 {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<String>();
        StringBuilder sb = new StringBuilder();
        // 循环s
        for (int i = 0; i < s.length(); i++) {
            char sItem = s.charAt(i);
            // 栈空且是字母，则直接append
            if (stack.empty() && Character.isLetter(sItem)) {
                sb.append(sItem);
                continue;
            }
            // 栈空且不是字母，则直接push
            if (stack.empty() && !Character.isLetter(sItem)) {
                stack.push(sItem + "");
                continue;
            }
            // 栈非空
            if (!stack.empty()) {
                if (sItem == ']') {
                    // 循环出栈，
                    StringBuilder sbItem = new StringBuilder();
                    int repeatNum = 0;
                    while (true) {
                        String stackItem = stack.pop();
                        // 如果碰到数字说明结束了
                        if (isNumeric(stackItem)) {
                            // 在来个循环获取数字。
                            repeatNum = getRepNum(stackItem, stack);
                            break;
                        }
                        if (!stackItem.equals("[")) {

                            for (int l = stackItem.length() - 1; l >=0; l--) {
                                sbItem.append(stackItem.charAt(l));
                            }

                        }
                    }
                    sbItem.reverse();
                    for (int j = 0; j < repeatNum; j++) {
                        stack.push(sbItem.toString());
                    }
                } else {
                    stack.push(sItem + "");
                }
            }

        }
        for (String m : stack) {
            sb.append(m);
        }

        return sb.toString();
    }

    private int getRepNum(String stackItem, Stack<String> stack) {
        int repeatNum = Integer.parseInt(stackItem);
        int pow = 1;
        while (true) {
            if (stack.empty()) break;
            String numItem = stack.pop();
            if (isNumeric(numItem)) {
                repeatNum += Math.pow(10, pow) * Integer.parseInt(numItem);
                pow++;
                continue;
            } else {
                stack.push(numItem);
            }
            break;
        }

        return repeatNum;
    }

    public static boolean isNumeric(String cs) {
        if (cs.isEmpty()) {
            return false;
        } else {
            int sz = cs.length();

            for(int i = 0; i < sz; ++i) {
                if (!Character.isDigit(cs.charAt(i))) {
                    return false;
                }
            }

            return true;
        }
    }

    public static void main(String[] args) {
        Solution394 solution394 = new Solution394();
        System.out.println(solution394.decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
        System.out.println(solution394.decodeString("2[abc]3[cd]ef"));
    }
}
