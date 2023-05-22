package org.fotech.bytedance;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 */
public class Solution121 {

    public int maxProfit(int[] prices) {
        // 遍历一次，记录价格最低值。然后遍历的之后只需要考虑和最低值的差值
        int minBuyPrice = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - minBuyPrice > profit) {
                profit = prices[i] - minBuyPrice;
            }

            if (prices[i] < minBuyPrice) {
                minBuyPrice = prices[i];
            }
        }

        return profit;
    }

    // 这个方法时间复杂度过高。可以记录一下买入的最低价格，如果price后面买入的价格要高于最低价，那就不用买了。
    public int res1(int[] prices) {
        // 返回 price[j] - price[i] 的最大值。其中 j > i
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            int buyprice = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                int sellprice = prices[j];
                max = Math.max(sellprice - buyprice, max);
            }
        }

        return max;
    }
}
