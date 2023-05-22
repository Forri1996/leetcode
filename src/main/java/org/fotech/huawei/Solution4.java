package org.fotech.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 描述
 * •输入一个字符串，请按长度为8拆分每个输入字符串并进行输出；
 *
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * 输入描述：
 * 连续输入字符串(每个字符串长度小于等于100)
 *
 * 输出描述：
 * 依次输出所有分割后的长度为8的新字符串
 */
public class Solution4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String input = in.nextLine();
            int length = input.length();
            List<String> result = getResult(input);
            System.out.println(result);
        }

    }


    private static List<String> getResult(String input) {
        List<String> result = new ArrayList<>();
        int length = input.length();
        int i = 0;
        while (i < length) {
            int start = i;
            int end = i + 8;
            if (end > length) {
                result.add(input.substring(start, length) + get0ByNum(8-length + start));
            } else {

                result.add(input.substring(start, end));
            }
            i = end;
        }

        return result;
    }

    private static String get0ByNum(int num) {
        String result = "";
        for (int i = 0; i < num; i++) {
            result += "0";
        }

        return result;
    }
}
