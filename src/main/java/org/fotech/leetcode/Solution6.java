package org.fotech.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Solution6 {
    public static void main(String[] args) {
        exec("PAYPALISHIRING", 3);
    }

    private static String exec(String input, int num) {
        if (num == 1) {
            return input;
        }
        List<List<String>> stringList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            stringList.add(new ArrayList<>());
        }
        int m = 0;
        boolean goLeft = true;
        for (int i = 0; i < input.length(); i++) {
            stringList.get(m).add(String.valueOf(input.charAt(i)));
            if (m == 0) {
                m++;
                goLeft = true;
                continue;
            }
            if (m == num - 1) {
                m--;
                goLeft = false;
                continue;
            }
            if (goLeft) {
                m++;
            } else {
                m--;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (List<String> str : stringList) {
            for (String k : str) {
                stringBuilder.append(k);
            }
        }

        return stringBuilder.toString();
    }
}
