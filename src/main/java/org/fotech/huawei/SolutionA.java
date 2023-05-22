package org.fotech.huawei;

import java.util.*;

/**
 * 先输入谜面再输入谜底。
 * 如果单词长度一样，包含的字符一样，则可以。
 * 如过谜面单词和谜底去重后是一样的，也可以。
 */
public class SolutionA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String mimian = sc.nextLine();
        String midi = sc.nextLine();

        List<String> mimianArr = Arrays.asList(mimian.split(","));
        List<String> midiArr = Arrays.asList(midi.split(","));

        List<String> result = new ArrayList<>();

        for (String target : mimianArr) {
            for (String item: midiArr) {
                if (judgeA(target, item) || judgeB(target, item)) {
                    result.add(target);
                }
            }
        }
        String resultStr = "";
        if (result.size() == 0) {
            System.out.println("not found");
        } else {
            for (int i = 0; i < result.size(); i++) {
                if (i == result.size() - 1) {
                    resultStr += result.get(i);
                } else {
                    resultStr += result.get(i) + ",";
                }
            }
        }
        System.out.println(resultStr);
    }

    // 判断是否重排一致
    private static boolean judgeA(String target, String item) {
        // 每个单词出现的次数，频率完全一致。
        // 字符串数组排序？
        char[] targetChar = target.toCharArray();
        char[] itemChar = item.toCharArray();
        Arrays.sort(targetChar);
        Arrays.sort(itemChar);

        return String.valueOf(targetChar).equals(String.valueOf(itemChar));
    }
    // 判断是否去重一致
    // 可以用双指针优化。
    private static boolean judgeB(String target, String item) {
        String quchongTarget = remove(target);
        String quchongItem = remove(item);

        return quchongTarget.equals(quchongItem);
    }

    // 对字符串进行去重
    private static String remove(String target) {
        StringBuilder result = new StringBuilder();
        Set<String> exist = new HashSet<>();
        for (int i = 0; i < target.length(); i++) {
            String m = String.valueOf(target.charAt(i));
            if (exist.contains(m)) {
                continue;
            }
            exist.add(m);
            result.append(m);
        }
        return result.toString();
    }
}
