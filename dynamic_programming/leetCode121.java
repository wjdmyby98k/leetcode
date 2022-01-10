package dynamic_programming;

/**
 * @author：THIEM
 * @create:2021/11/2-21:01
 * 买卖股票的最佳时机
 * 用贪心也可以做，这里用动态规划做
 * dp[i][0] 表示第i天持有股票所得最多现金
 * 0表示持有，1表示不持有
 */
public class leetCode121 {
    public int maxProfit(int[] prices) {
        int[][] dp =new int[prices.length][2];
        dp[0][0]=-prices[0];
        dp[0][1]=0;
        for(int i=1;i<prices.length;i++){
            dp[i][0]= Math.max(dp[i-1][0],-prices[i]); // 第i天持有股票，i-1天就持有  或  i天买入
            dp[i][1]= Math.max(dp[i-1][1],dp[i-1][0]+prices[i]); //第i天不持有股票，i-1天就不持有  或  i-1天持有并卖出
        }
        return dp[prices.length-1][1];
    }
}
