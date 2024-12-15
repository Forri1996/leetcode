package org.fotech.huawei;

/**
 * ‌华为OD机试字符串拼接算法题‌要求从给定的字符列表中取出任意字符（
 * 每个字符只能用一次）拼接成长度为N的字符串，且相同的字符不能相邻。
 * 目标是计算出给定的字符列表能拼接出多少种满足条件的字符串，如果输入非法或者无法拼接出满足条件的字符串，则返回0。
 *
 * 解题思路
 * ‌回溯法‌：通过递归的方式尝试所有可能的字符组合，当找到一个有效的组合时，
 * 将其计数并继续尝试其他组合。这种方法适用于字符数量较少的情况，但当字符数量较多时，可能会导致性能问题。
 * ‌动态规划‌：通过构建一个状态转移方程来避免重复计算，
 * 逐步构建满足条件的字符串，并记录每种状态下的有效组合数量。这种方法在处理大量数据时更为高效。
 * 输入：
 * abc 1
 *
 * 输出：
 * 3
 * 说明：
 * 给定的字符为 abc ，结果字符申长度为 1 ，可以拼接成 a、b、c ，共 3 种。
 *
 * abc 2
 * ab ac ba bc ca cb
 *
 * abc 3
 * abc acb
 *
 * 输入：
 * dde 2
 * 输出：
 * 2
 * 说明：
 * 给定的字符为 dde ，果字符串长度为 2 ，可以拼接成 de、ed， 共 2 种。
 */
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Homework6 {

    public static void generateDistinctStrings(String s, int length, StringBuilder current, Set<String> result, boolean[] used) {
        // 当生成的字符串长度等于指定长度时，将其加入结果集中
        if (current.length() == length) {
            result.add(current.toString());
            return;
        }

        // 遍历字符串中的字符
        for (int i = 0; i < s.length(); i++) {
            if (used[i] || (current.length() > 0 && current.charAt(current.length() - 1) == s.charAt(i))) {
                // 如果字符已被使用或与前一个字符相同，则跳过当前字符
                continue;
            }
            // 标记当前字符已使用
            used[i] = true;
            // 递归调用生成下一个字符
            current.append(s.charAt(i));
            generateDistinctStrings(s, length, current, result, used);
            // 取消标记当前字符使用状态，并移除最后一个字符，以便下一次遍历
            used[i] = false;
            current.deleteCharAt(current.length() - 1);
        }
    }

    // 计算满足条件的不同字符串的数量
    public static int countDistinctStrings(String s, int length) {
        // 创建一个集合来存储不同的字符串
        Set<String> distinctStrings = new HashSet<>();
        // 创建一个数组来标记字符串中的字符是否已经被使用
        boolean[] used = new boolean[s.length()];
        // 调用generateDistinctStrings方法生成满足条件的不同字符串
        StringBuilder current = new StringBuilder();
        generateDistinctStrings2(s, length, current, distinctStrings, used);
        // 返回不同字符串的数量
        return distinctStrings.size();
    }

    private static void generateDistinctStrings2(String s, int length, StringBuilder current,
                                                 Set<String> distinctStrings, boolean[] used) {
        // 判断退出条件
        if (current.length() == length) {
            distinctStrings.add(current.toString());
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if (used[i] || (current.length() > 0) && current.charAt(i-1) == s.charAt(i)) {
                // 判断不处理的条件：已经使用过的元素 ｜｜ 和前一个相等的元素
                continue;
            }
            used[i] = true;
            current.append(s.charAt(i));
            generateDistinctStrings(s, length, current, distinctStrings, used);
            // 走到这里，说明return了，那么这一位就设置成未使用
            used[i] = false;
            current.deleteCharAt(current.length()-1);
        }
    }

    public static void main(String[] args) {
        // 读取用户输入的字符串
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入字符串和长度（用空格分隔）: ");
        String inputStr = scanner.nextLine();
        // 将输入的字符串空格分割为两部分，分别是字符串及长度
        String[] parts = inputStr.split(" ");
        // 获取输入的字符串
        String s = parts[0];
        // 将输入的长度部分转化为整数
        int length = Integer.parseInt(parts[1]);

        // 调用countDistinctStrings方法计算满足条件的不同字符串的数量
        int count = countDistinctStrings(s, length);
        // 输出所有不同的字符串（如果需要）
        // for (String string : distinctStrings) {
        //     System.out.println(string);
        // }
        // 输出计算结果
        System.out.println("满足条件的不同字符串的数量: " + count);
    }
}
