package org.fotech.huawei;

import java.util.Locale;
import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别

        String str = in.nextLine();
        String target = in.nextLine();
        System.out.println(calNum(str, target));

    }

    public static int calNum(String str, String target) {
        str = str.toLowerCase().replace(" ", "");
        target = target.toLowerCase();
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            if (String.valueOf(str.charAt(i)).equals(target)) {
                result++;
            }
        }

        return result;
    }
}
