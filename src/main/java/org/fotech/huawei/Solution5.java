package org.fotech.huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String input = in.nextLine();
            int x = Integer.parseInt(input.substring(2), 16);
            System.out.println(x);
        }
    }

}
