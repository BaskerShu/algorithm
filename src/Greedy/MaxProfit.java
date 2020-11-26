package Greedy;

/**
 * 121. 买卖股票的最佳时机
 */
public class MaxProfit {
    /**
     * 即第i天的最大差值 =
     * max(前i-1天的最大差值， 第i天的抛出价格-前i-1天的最小买入价格)
     * 所以只需要遍历1次数组 更新 最小买入价格min_val 和 最大差值max_val即可
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;

        int min_val = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(profit, prices[i] - min_val);
            min_val = Math.min(min_val, prices[i]);
        }
        return profit;
    }
}
