package Greedy;

/**
 * 122. 买卖股票的最佳时机 II
 */
public class MaxProfit2 {

    // 动态规划
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;

        int n = prices.length;
        int dp0 = 0; // 没有股票的最大收益
        int dp1 = -prices[0];  // 有股票的最大收益
        for (int price : prices) {
            int newdp0 = Math.max(dp1 + price, dp0);
            int newdp1 = Math.max(dp0 - price, dp1);
            dp0 = newdp0;
            dp1 = newdp1;
        }
        return dp0;
    }

    // 贪心算法
    public int maxProfit2(int[] prices) {
        if (prices.length == 0) return 0;

        int profix = 0;
        for (int i = 1; i < prices.length; i++) {
            profix += Math.max(0, prices[i] - prices[i - 1]);
        }
        return profix;
    }
}
