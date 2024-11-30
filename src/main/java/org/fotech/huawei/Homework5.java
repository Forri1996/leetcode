package org.fotech.huawei;

import java.util.Scanner;

/**
 * 最小回文素数
 * leetcode866
 */
public class Homework5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        for (int i = m; i < Integer.MAX_VALUE; i++) {
            if (isReverse(i)) {
                System.out.println(i + "是回文数");
                if (isSushu(i)) {
                    System.out.println(i + "是素数");
                    break;
                }
            }
        }
    }

    // 判断是否是回文数
    private static boolean isReverse(int num) {
        String str = String.valueOf(num);
        int i = 0;
        int k = str.length() - 1;
        while (true) {
            if (str.charAt(i) != str.charAt(k)) {
                return false;
            } else {
                i++;
                k--;
            }
            if (i > k) {
                return true;
            }
        }
    }

    private static boolean isSushu(int num) {
        for (int i = 2; i < num/2; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
