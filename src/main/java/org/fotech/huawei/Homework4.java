package org.fotech.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * 题目描述
 * 题目要求对输入的字符串中的下划线进行统一替换。具体规则如下：
 *
 * 将每一个下划线_替换为特殊字符串(^|$|[,+])。
 * 以下划线在方括号内的内容不替换。
 * 转义的下划线（即\_）不替换。
 * 输入字符串的长度范围为[0, 10000]。
 */
public class Homework4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String src = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        Stack<String> lockList = new Stack<>();
        for (int i = 0; i < src.length(); i++) {
            char cur = src.charAt(i);

            if (cur == '[') {
                lockList.push("lock");
                sb.append(cur);
                continue;
            }
            if (cur == ']') {
                lockList.pop();
                sb.append(cur);
                continue;
            }
            if (lockList.size() > 0) {
                sb.append(cur);
                continue;
            }
            if (cur != '_') {
                sb.append(cur);
                continue;
            } else {
                if (i > 0) {
                    char pre = src.charAt(i-1);
                    if (pre == '\\') {
                        sb.append(cur);
                        continue;
                    } else {
                        sb.append("(^|$|[,+])");
                        continue;
                    }
                }
            }
        }
        System.out.println(sb.toString());
    }
}
