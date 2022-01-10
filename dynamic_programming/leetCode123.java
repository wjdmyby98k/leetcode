package dynamic_programming;

/**
 * @author：THIEM
 * @create:2021/11/3-22:00
 * 买卖股票的最佳时机III
 * 最多只能买两次
 * 0-4分别代表----不操作，第一次买，第一次卖，第二次买，第二次卖
 * 这里的状态，不是仅仅代表当天的状态，是代表当天及之前一直处于什么状态
 * 那为什么是要返回第二次卖？
 */
public class leetCode123 {
    public int maxProfit(int[] prices) {
        int[][] dp=new int[prices.length][5];
        dp[0][1]=-prices[0];
        dp[0][3]=-prices[0];//第二次卖也要初始化为-prices[0]
        for(int i=1;i<prices.length;i++){
            dp[i][0]= dp[i-1][0];
            dp[i][1]= Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
            dp[i][2]= Math.max(dp[i-1][2],dp[i-1][1]+prices[i]);
            dp[i][3]= Math.max(dp[i-1][3],dp[i-1][2]-prices[i]);
            dp[i][4]= Math.max(dp[i-1][4],dp[i-1][3]+prices[i]);
        }
//        System.out.println(Arrays.deepToString(dp));
        return dp[prices.length-1][4];
    }
}
