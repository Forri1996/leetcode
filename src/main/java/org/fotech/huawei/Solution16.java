package org.fotech.huawei;

import java.util.Scanner;

/**
 * https://www.nowcoder.com/practice/f9c6f980eeec43ef85be20755ddbeaf4?tpId=37&rp=1&ru=%2Fexam%2Foj%2Fta&qru=%2Fexam%2Foj%2Fta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D37&difficulty=&judgeStatus=&tags=&title=&gioEnter=menu
 *
 * 购物单问题（特色背包问题）
 * 可以单独买主件
 * 购买附件则必须先买对应的主件
 * 主件最多有2个附件
 * 总满意度为商品价格*商品满意度
 *
 * 转换成状态转移方程。当前状态有几种可能性：不买，只买主，买主+副1，买主+副2，买主+副1+副2
 * dp[i][j]表示前面的i件物品，在容量为j的时候的最大满意度。
 */
public class Solution16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 总价格
        int N = sc.nextInt();
        // 商品的数量
        int m = sc.nextInt();

        Good[] goods = new Good[m];
        for (int i = 0; i < m; i++) {
            goods[i] = new Good();
        }

        for (int i = 0; i < m; i++) {
            // 商品价格
            int price = sc.nextInt();
            // 商品满意度
            int myd = sc.nextInt();
            // 商品是否主or谁的副
            int mainNum = sc.nextInt();
            Good good = goods[i];
            good.isMain = mainNum == 0;
            good.myd = myd;
            good.price = price * myd;
            if (mainNum > 0) {
                if (goods[mainNum - 1].bakA == -1) {
                    goods[mainNum - 1].bakA = i;
                } else if (goods[mainNum - 1].bakB == -1) {
                    goods[mainNum - 1].bakB = i;
                }
            }
        }

        // todo 状态转移
    }

}


class Good {
    // 价格
    public int price;
    // 满意度
    public int myd;
    // 是否为主
    public boolean isMain;
    // 副A
    public int bakA;
    // 副B
    public int bakB;
}
