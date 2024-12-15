package org.fotech.huawei;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * 题目描述
 * 题目要求向一个空栈中压入一系列正整数，每当压入一个整数时，需要检查栈顶元素是否满足以下规则：
 *
 * ‌规则1‌：如果栈顶两个元素相等，则将这两个元素弹出，并压入它们的两倍值。
 * ‌规则2‌：如果栈顶元素等于栈中前若干元素之和（范围为3到n），则将这些元素弹出，并压入栈顶元素的两倍值。
 * 循环检查，直到没有规则可以应用为止‌12。
 * 输入输出描述
 * ‌输入‌：使用单个空格隔开的正整数的字符串，如”5 6 7 8″，左边的数字先入栈，输入的正整数个数为 x，1<=x<=1000。
 * ‌输出‌：最终栈中存留的数字‌1。
 * 示例
 * 例如，依次向栈压入6、1、2、3，当压入2时，栈顶至栈底依次为[2、1、6]；
 * 当压入3时，3=2+1，3、2、1全部出栈，重新入栈整数6，
 * 此时栈顶至栈底依次为[6、6]；6=6，两个6全部出栈，压入12，最终栈中只剩个元素12。
 */
public class Homework3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] m =  sc.nextLine().split(" ");
        int[] numArr = new int[m.length];
        for (int i = 0; i < m.length; i++) {
            numArr[i] = Integer.parseInt(m[i]);
        }

        Stack<Integer> stack = new Stack<>();
        for (int num : numArr) {
            stack.push(num);
            while (check(stack)) {

            }
        }
        System.out.println(stack);
    }

    private static boolean check(Stack<Integer> stack) {
        int n = stack.peek();
        int len = stack.size();
        if (stack.size() >= 2 && stack.get(len-1 ) == stack.get(len-2)) {
            stack.pop();
            stack.pop();
            stack.push(n * 2);
            return true;
        }
        // 如果栈顶元素等于栈中前若干元素之和（范围为3到n），则将这些元素弹出，并压入栈顶元素的两倍值。
        int total = 0;
        for (int i = len - 2; i >=0; i--) {
            total += stack.get(i);
            if (total == n) {
                for (int k = i; k < len; k++) {
                    stack.pop();
                }
                stack.push(2 * n);
                return true;
            }
        }

        return false;

    }
}

