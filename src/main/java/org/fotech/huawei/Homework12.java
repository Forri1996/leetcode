package org.fotech.huawei;

import java.util.Scanner;

/**
 * 题目描述
 * 有一个特异性的双端队列，该队列可以从头部或尾部添加数据，但是只能从头部移出数据。
 *
 * 小A依次执行2n个指令往队列中添加数据和移出数据。其中n个指令是添加数据（可能从头部添加、也可能从尾部添加），依次添加1到n；n个指令是移出数据。
 *
 * 现在要求移除数据的顺序为1到n。
 *
 * 为了满足最后输出的要求，小A可以在任何时候调整队列中数据的顺序。
 *
 * 请问 小A 最少需要调整几次才能够满足移除数据的顺序正好是1到n；
 *
 * 输入描述
 * 第一行一个数据n，表示数据的范围。
 *
 * 接下来的2n行，其中有n行为添加数据，指令为：
 *
 * "head add x" 表示从头部添加数据 x，
 * "tail add x" 表示从尾部添加数据x，
 * 另外 n 行为移出数据指令，指令为："remove" 的形式，表示移出1个数据；
 *
 * 1 ≤ n ≤ 3 * 10^5。
 *
 * 所有的数据均合法。
 */
public class Homework12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer num  = sc.nextInt();
        int res = 0;
        boolean isSorted = true;
        for (int i = 0; i < num; i++) {
            String action = sc.nextLine();
            if (i == 0) {
                continue;
            } else {
                // 头插，顺序变乱
                if (action.contains("head add")) {
                    isSorted = false;
                } else if (action.contains("tail add")) {
                    continue;
                } else if (action.contains("remove")) {
                    if (!isSorted) {
                        isSorted = true;
                        res++;
                    }
                }
            }

        }
    }
}
