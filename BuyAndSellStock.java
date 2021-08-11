//https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
public class buyAndSellStock {
     class Solution1 {
        public int maxProfit(int prices[]) {
            int maxprofit = 0;
            for (int i = 0; i < prices.length - 1; i++) {
                for (int j = i + 1; j < prices.length; j++) {
                    int profit = prices[j] - prices[i];
                    if (profit > maxprofit) {
                        maxprofit = profit;
                    }
                }
            }
            return maxprofit;
        }
    }
    public class Solution2 {
        public int maxProfit(int prices[]) {
            int minprice = Integer.MAX_VALUE;
            int maxprofit = 0;
            for (int i = 0; i < prices.length; i++) {
                if (prices[i] < minprice) {
                    minprice = prices[i];
                } else if (prices[i] - minprice > maxprofit) {
                    maxprofit = prices[i] - minprice;
                }
            }
            return maxprofit;
        }
    }

    class Solution3 {
        public int maxProfit(int[] prices) {
            int len = prices.length;
            int res = 0;
            // 前一天卖出可以获得的最大利润
            int pre = 0;
            for (int i = 1; i < len; i++) {
                // 利润差
                int diff = prices[i] - prices[i - 1];
                // 状态转移方程：第i天卖出可以获得的最大利润 = 第i-1天卖出的最大利润 + 利润差
                pre = Math.max(pre + diff, 0);
                res = Math.max(res, pre);
            }
            return res;
        }
    }
}
