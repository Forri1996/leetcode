package org.fotech.huawei;


import java.util.*;
import java.util.stream.Collectors;

/**
 * 题目描述
 * 给定一个字符串s，s包括以空格分隔的若干个单词，请对s进行如下处理后输出：
 * 1、单词内部调整：对每个单词字母重新按字典序排序
 * 2、单词间顺序调整：
 * 1）统计每个单词出现的次数，并按次数降序排列
 * 2）次数相同，按单词长度升序排列
 * 3）次数和单词长度均相同，按字典升序排列
 *
 * 请输出处理后的字符串，每个单词以一个空格分隔。
 *
 * 输入描述
 * 一行字符串，每个字符取值范围：[a-zA-z0-9]以及空格，字符串长度范围：[1，1000]
 *
 * 输出描述
 * 输出处理后的字符串，每个单词以一个空格分隔。
 */
public class Homework8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] inputArr = input.split(" ");
        List<String> strArr = Arrays.stream(inputArr).map(e -> {
            char[] item = e.toCharArray();
            Arrays.sort(item);
            return new String(item);
        }).collect(Collectors.toList());

        Map<String, Integer> countMap = new HashMap<>();
        for (String s : strArr) {
            if (countMap.containsKey(s)) {
                countMap.put(s, countMap.get(s)+1);
            } else {
                countMap.put(s, 1);
            }
        }

        List<String> result = strArr.stream().sorted((a,b) -> {
            return !(countMap.get(a) == countMap.get(b)) ? countMap.get(b) - countMap.get(a) :
                    a.length() != b.length() ? a.length()- b.length() :
                            a.compareTo(b);
        }).collect(Collectors.toList());
    }
}
