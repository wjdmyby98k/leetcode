package dynamic_programming;

import java.util.Arrays;

/**
 * @author：THIEM
 * @create:2021/10/28-20:41
 */
public class leetCode322 {
    //先背包，后物品
//    public int coinChange(int[] coins, int amount) {
//        int[] dp=new int[amount+1];
//        Arrays.fill(dp,Integer.MAX_VALUE); // 初始化为最大值
//        dp[0]=0;  // dp[j]含义为,  凑足总额为j所需钱币的最少个数为dp[j]
//        for(int j=0;j<=amount;j++){
//            for(int i=0;i<coins.length;i++){
//                if(j>=coins[i] && dp[j-coins[i]]!=Integer.MAX_VALUE){ //后面加一个条件是为了防止+1溢出int最大值
//                    dp[j]= Math.min(dp[j],dp[j-coins[i]]+1);
//                }
//            }
//        }
//
//        return dp[amount]==Integer.MAX_VALUE? -1:dp[amount];
//    }

    //先物品,后背包
    public int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE); // 初始化为最大值
        dp[0]=0;  // dp[j]含义为,  凑足总额为j所需钱币的最少个数为dp[j]
        for(int i=0;i<coins.length;i++){
            for(int j=coins[i];j<=amount;j++){
                if(dp[j-coins[i]]!=Integer.MAX_VALUE){  //这里同样也要考虑是否越界
                    dp[j]= Math.min(dp[j],dp[j-coins[i]]+1);
                }
            }
        }

        return dp[amount]==Integer.MAX_VALUE? -1:dp[amount];
    }


}
