package org.fotech.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 题目描述
 * 羊、狼、农夫都在岸边，当羊的数量小于狼的数量时，狼会攻击羊，农夫则会损失羊。农夫有一艘容量固定的船，能够承载固定数量的动物。
 *
 * 要求求出不损失羊情况下将全部羊和狼运到对岸需要的最小次数。
 *
 * 只计算农夫去对岸的次数，回程时农夫不会运送羊和狼。
 *
 * 备注：农夫在或农夫离开后羊的数量大于狼的数量时狼不会攻击羊。
 *
 * 输入描述
 * 第一行输入为M，N，X， 分别代表羊的数量，狼的数量，小船的容量。
 *
 * 输出描述
 * 输出不损失羊情况下将全部羊和狼运到对岸需要的最小次数（若无法满足条件则输出0）。
 */
public class Homework13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        Integer sheep = Integer.parseInt(input[0]);
        Integer woaf = Integer.parseInt(input[1]);
        Integer boat = Integer.parseInt(input[2]);

        List<Integer> ans = new ArrayList<>();

        dfs(sheep, woaf, 0, 0, 0, boat, ans);
    }

    private static void dfs(Integer sheep, Integer woaf, int cur, int boat, int rSheep, int rWoaf, List<Integer> ans) {
        if (sheep == 0 && woaf == 0) {
            ans.add(cur);
            return;
        }
        if (sheep + woaf <= boat) {
            ans.add(cur + 1);
            return;
        }
        for (int i = 0; i < Math.min(sheep, boat); i++) {
            for (int j = 0; j < Math.min(woaf, boat); j++) {
                if (sheep - i < woaf - j) {
                    continue;
                }
                if (rSheep + i < rWoaf + j) {
                    continue;
                }
                dfs(sheep - i, woaf - j, cur+1, boat, rSheep+i, rWoaf+j, ans);
            }
        }
    }
}
