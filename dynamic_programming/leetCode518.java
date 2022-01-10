package dynamic_programming;

/**
 * @author：THIEM
 * @create:2021/10/28-0:06
 * 零钱兑换，先遍历物品，后遍历背包，这样得到组合数
 * 分清楚到底是求方式，还是求价值，方式分为排列和组合
 * 方式和价值的递推公式不一样
 */
public class leetCode518 {
    public int change(int amount, int[] coins) {
        int[] dp=new int[amount+1];
        dp[0]=1;
        for(int i=0;i<coins.length;i++){
            for(int j=coins[i];j<=amount;j++){
                dp[j]+=dp[j-coins[i]];
            }
        }
        return dp[amount];
    }
}
