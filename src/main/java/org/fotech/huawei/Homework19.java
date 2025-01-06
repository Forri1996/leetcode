package org.fotech.huawei;

import java.util.*;

/**
 * 题目描述
 * 有N条线段，长度分别为a[1]-a[n]。
 *
 * 现要求你计算这N条线段最多可以组合成几个直角三角形。
 *
 * 每条线段只能使用一次，每个三角形包含三条线段。
 *
 * 输入描述
 * 第一行输入一个正整数T（1<＝T<＝100），表示有T组测试数据.
 *
 * 对于每组测试数据，接下来有T行，
 *
 * 每行第一个正整数N，表示线段个数（3<＝N<＝20），接着是N个正整数，表示每条线段长度，（0<a[i]<100）。
 *
 * 输出描述
 * 对于每组测试数据输出一行，每行包括一个整数，表示最多能组合的直角三角形个数
 */
public class Homework19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer num = Integer.parseInt(sc.nextLine());
        List<Integer[]> input = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer[] item = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            input.add(item);
        }
        Set<String> ans = new HashSet<>();
        for (Integer[] item : input) {
            if (item.length < 3) {

            } else {
                for (int i = 0; i < item.length-2; i++) {
                    for (int j = i+1; j < item.length-1; j++) {
                        for (int k = j+1; k < item.length; k++) {
                            if (item[i] * item[i] + item[j] * item[j] == item[k] * item[k]) {
                                String m = item[i]+","+item[j]+","+item[k];
                                ans.add(m);
                            }
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
