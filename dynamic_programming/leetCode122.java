package dynamic_programming;

/**
 * @author：THIEM
 * @create:2021/11/3-21:52
 * 买卖股票的最佳时机 II
 * 可以多次买入，但是不能同时多笔交易
 * dp[i][0] 表示第i天持有股票所得最多现金
 * 0表示持有，1表示不持有
 */
public class leetCode122 {
    public int maxProfit(int[] prices) {
        int[][] dp=new int[prices.length][2];
        dp[0][0]=-prices[0];
        dp[0][1]=0;
        for(int i=1;i<prices.length;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]-prices[i]);  //第i天持有=第i-1天持有  或  第i-1天不持有，第i天买入
            dp[i][1]= Math.max(dp[i-1][1],dp[i-1][0]+prices[i]); //第i天不持有=第i-1天不持有  或  第i-1天持有，第i天卖出
        }
        return dp[prices.length-1][1];
    }
}
