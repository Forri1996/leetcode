package org.fotech.huawei;

import java.util.*;

/**
 * 题目描述
 * 如果一个字符串正读和反渎都一样（大小写敏感），则称它为一个「回文串」，例如：
 *
 * leVel是一个「回文串」，因为它的正读和反读都是leVel；同理a也是「回文串」
 * art不是一个「回文串」，因为它的反读tra与正读不同
 * Level不是一个「回文串」，因为它的反读leveL与正读不同（因大小写敏感）
 * 给你一个仅包含大小写字母的字符串，请用这些字母构造出一个最长的回文串，若有多个最长的，返回其中字典序最小的回文串。
 *
 * 字符串中的每个位置的字母最多备用一次，也可以不用。
 *
 * 输入描述
 * 无
 *
 * 输出描述
 * 无
 *
 * 用例
 * 输入	abczcccddzz
 * 输出	ccdzazdcc
 * 说明	无
 * 输入	ABabBabA
 * 输出	ABabbaBA
 * 说明	无
 */
public class Homework17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(i, i + 1);
            if (map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
            } else {
                map.put(str, 1);
            }
        }
        List<String> mid = new ArrayList<>();
        List<String> ans = new ArrayList<>();

        map.forEach((e,v) -> {
            if (v == 1) {
                mid.add(e);
            }
            if (v > 1) {
                if (v % 2 == 0) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < v/2; i++) {
                        sb.append(e);
                    }
                    ans.add(sb.toString());
                } else {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < (v-1)/2; i++) {
                        sb.append(e);
                    }
                    ans.add(sb.toString());
                    mid.add(e);
                }
            }
        });

        mid.sort(String::compareTo);
        ans.sort(String::compareTo);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ans.size(); i++) {
            sb.append(ans.get(i));
        }
        sb.append(mid.get(0));
        for (int i = ans.size()-1; i >=0; i--) {
            sb.append(ans.get(i));
        }
        System.out.println(sb.toString());
    }
}
