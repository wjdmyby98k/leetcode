package dynamic_programming;

/**
 * @author：THIEM
 * @create:2021/11/4-10:08
 * 买卖股票的最佳时机IV
 * 最多只能买两次
 * 0-2k+1分别代表----不操作，第一次买，第一次卖，第二次买，第二次卖...
 * 奇数是买，偶数是卖
 * 这里的状态，不是仅仅代表当天的状态，是代表当天及之前一直处于什么状态
 * 为什么不用考虑数组长度为1，因为数组长度为1，循环进不去，只有奇数被初始化，偶数是0，最后返回的也是偶数次
 */
public class leetCode188 {
    public int maxProfit(int k, int[] prices) {
        int[][] dp=new int[prices.length][2*k+1];
        if(k==0 || prices.length==0) return 0;
        for(int i=1;i<2*k+1;i+=2){
            dp[0][i]=-prices[0];
        }
        for(int i=1;i<prices.length;i++){
            for(int j=1;j<2*k+1;j+=2){
                dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1]-prices[i]);
                dp[i][j+1]= Math.max(dp[i-1][j+1],dp[i-1][j]+prices[i]);
            }
        }
        return dp[prices.length-1][2*k];
    }
}
