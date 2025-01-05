package org.fotech.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 题目描述
 * 对称就是最大的美学，现有一道关于对称字符串的美学。已知：
 *
 * 第1个字符串：R
 * 第2个字符串：BR
 * 第3个字符串：RBBR
 * 第4个字符串：BRRBRBBR
 * 第5个字符串：RBBRBRRBBRRBRBBR
 * 相信你已经发现规律了，没错！就是第 i 个字符串 = 第 i - 1 号字符串取反 + 第 i - 1 号字符串；
 *
 * 取反（R->B, B->R）;
 *
 * 现在告诉你n和k，让你求得第n个字符串的第k个字符是多少。（k的编号从0开始）
 *
 * 输入描述
 * 第一行输入一个T，表示有T组用例；
 *
 * 解析来输入T行，每行输入两个数字，表示n，k
 *
 * 1 ≤ T ≤ 100；
 * 1 ≤ n ≤ 64；
 * 0 ≤ k ＜ 2^(n-1)；
 * 输出描述
 * 输出T行表示答案；
 *
 * 输出 "blue" 表示字符是B；
 *
 * 输出 "red" 表示字符是R。
 */
public class Homework15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer num = Integer.parseInt(sc.nextLine());
        List<String> res = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            String[] input = sc.nextLine().split(" ");
            // 第n个字符串
            int n = Integer.parseInt(input[0]);
            // 第k个字符
            long k = Long.parseLong(input[1]);
            res.add(get(n, k, false));
        }
    }

    private static String get(int n, long k, boolean isReserve) {
        if (n == 2) {
            if (k == 0) {
                if (isReserve) return "RED";
                return "BLUE";
            }
            if (k == 1) {
                if (isReserve) return "BLUE";
                return "RED";
            }
        } else {
            long half = 1L << (n-2);
            if (k > half) {
                return get(n-1, k-half, false);
            } else {
                return get(n-1, k, true);
            }
        }

        return "";
    }
}
