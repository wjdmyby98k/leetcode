package dynamic_programming;

/**
 * @author：THIEM
 * @create:2021/11/4-17:29
 * 买卖股票的最佳时机含手续费，可以买多次，多了个手续费
 * 和122的一个套路，就是多个手续费，手续费可以理解成买入或者卖出，这里理解为卖出的时候交手续费
 * 依旧是0代表持有，1代表不持有
 */
public class leetCode714 {
    public int maxProfit(int[] prices, int fee) {
        int[][] dp=new int[prices.length][2];
        dp[0][0]=-prices[0];//初始化第一天持有股票
        for(int i=1;i<prices.length;i++){
            //第i天持有=前一天持有  或  前一天不持有在今天买入
            dp[i][0]= Math.max(dp[i-1][0],dp[i-1][1]-prices[i]);
            //第i天不持有=前一天不持有  或  前一天持有在今天卖出，但是要手续费
            dp[i][1]= Math.max(dp[i-1][1],dp[i-1][0]+prices[i]-fee);
        }
        return Math.max(dp[prices.length-1][1],dp[prices.length-1][0]);
    }
}
