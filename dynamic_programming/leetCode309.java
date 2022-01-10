package dynamic_programming;

/**
 * @author：THIEM
 * @create:2021/11/4-10:
 * 最佳买卖股票时机含冷冻期
 * 股票系列都是看的题解，有一点点难，说实话。
 * 状态一：买入股票状态（今天买入股票，或者是之前就买入了股票然后没有操作）
 * 卖出股票状态，这里就有两种卖出股票状态
 *    状态二：两天前就卖出了股票，度过了冷冻期，一直没操作，今天保持卖出股票状态
 *    状态三：今天卖出了股票
 * 状态四：今天为冷冻期状态，但冷冻期状态不可持续，只有一天！
 */
public class leetCode309 {
    public int maxProfit(int[] prices) {
        if(prices.length<2) return 0;
        int[][] dp= new int[prices.length][4];
        dp[0][0]=-prices[0];
        for(int i=1;i<prices.length;i++){
            //买入股票=前一天买入  或  前一天卖出今天买入  或  前一天冻结今天买入
            dp[i][0]= Math.max(dp[i-1][0], Math.max(dp[i-1][1]-prices[i],dp[i-1][3]-prices[i]));
            // 两天前卖出的，过了冻结没操作保持卖出状态=前一天也是这个状态   或  前一天是冻结
            dp[i][1]= Math.max(dp[i-1][3],dp[i-1][1]);
            // 今天卖出=前一天买入，今天卖出
            dp[i][2]=dp[i-1][0]+prices[i];
            // 今天冻结=前一天卖出
            dp[i][3]=dp[i-1][2];

        }
        int ans1= Math.max(dp[prices.length-1][1],dp[prices.length-1][2]);
        int ans = Math.max(ans1,dp[prices.length-1][3]);
        return ans;
    }
}
