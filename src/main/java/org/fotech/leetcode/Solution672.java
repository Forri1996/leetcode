package org.fotech.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 房间中有 n 只已经打开的灯泡，编号从 1 到 n 。墙上挂着 4 个开关 。
 *
 * 这 4 个开关各自都具有不同的功能，其中：
 *
 * 开关 1 ：反转当前所有灯的状态（即开变为关，关变为开）
 * 开关 2 ：反转编号为偶数的灯的状态（即 0, 2, 4, ...）
 * 开关 3 ：反转编号为奇数的灯的状态（即 1, 3, ...）
 * 开关 4 ：反转编号为 j = 3k + 1 的灯的状态，其中 k = 0, 1, 2, ...（即 1, 4, 7, 10, ...）
 * 你必须 恰好 按压开关 presses 次。每次按压，你都需要从 4 个开关中选出一个来执行按压操作。
 *
 * 给你两个整数 n 和 presses ，执行完所有按压之后，返回 不同可能状态 的数量。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 1, presses = 1
 * 输出：2
 * 解释：状态可以是：
 * - 按压开关 1 ，[关]
 * - 按压开关 2 ，[开]
 * 示例 2：
 *
 * 输入：n = 2, presses = 1
 * 输出：3
 * 解释：状态可以是：
 * - 按压开关 1 ，[关, 关]
 * - 按压开关 2 ，[开, 关]
 * - 按压开关 3 ，[关, 开]
 * 示例 3：
 *
 * 输入：n = 3, presses = 1
 * 输出：4
 * 解释：状态可以是：
 * - 按压开关 1 ，[关, 关, 关]
 * - 按压开关 2 ，[关, 开, 关]
 * - 按压开关 3 ，[开, 关, 开]
 * - 按压开关 4 ，[关, 开, 开]
 */
public class Solution672 {
    public static void main(String[] args) {
        int n = 3;
        int press = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("1");
        }
        Set<String> result = new HashSet<>();
        List<Integer> curr = new ArrayList<>();
        generateCombinations(result, curr,0, n, press, sb.toString());
        System.out.println(result);
        System.out.println(curr);
    }
    private static void generateCombinations(Set<String> result, List<Integer> currentCombination, int start, int n, int m, String str) {
        if (m == 0) {
            for (int i : currentCombination) {
                result.add(execByNum(i, str));
            }
            return;
        }

        for (int i = start; i <= n; i++) {
            currentCombination.add(i);
            generateCombinations(result, currentCombination, i + 1, n, m - 1, str);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }
    private static String execByNum(int i, String light) {
        if (i % 4 == 0) {
            return trigger1(light);
        }
        if (i % 4 == 1) {
            return trigger2(light);
        }
        if (i % 4 == 2) {
            return trigger3(light);
        }
        if (i % 4 == 3) {
            return trigger4(light);
        }
        return "";
    }

    private static String trigger1(String light) {
        StringBuilder sb =new StringBuilder();
        for (int i = 0; i < light.length(); i++) {
            if (light.charAt(i) == '0') {
                sb.append("1");
            } else {
                sb.append("0");
            }
        }

        return sb.toString();
    }

    private static String trigger2(String light) {
        StringBuilder sb =new StringBuilder();
        for (int i = 0; i < light.length(); i++) {
            if (i % 2 == 0) {
                if (light.charAt(i) == '0') {
                    sb.append("1");
                } else {
                    sb.append("0");
                }
            } else {
                sb.append(light.charAt(i));
            }

        }

        return sb.toString();
    }

    private static String trigger3(String light) {
        StringBuilder sb =new StringBuilder();
        for (int i = 0; i < light.length(); i++) {
            if (i % 2 == 1) {
                if (light.charAt(i) == '0') {
                    sb.append("1");
                } else {
                    sb.append("0");
                }
            } else {
                sb.append(light.charAt(i));
            }

        }

        return sb.toString();
    }

    private static String trigger4(String light) {
        StringBuilder sb =new StringBuilder();
        for (int i = 0 ; i < light.length(); i++) {
            if ((i)%3 == 0) {
                if (light.charAt(i) == '0') {
                    sb.append("1");
                } else {
                    sb.append("0");
                }
            } else {
                sb.append(light.charAt(i));
            }

        }

        return sb.toString();
    }
}
