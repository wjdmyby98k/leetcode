package dynamic_programming;

import java.util.Arrays;

/**
 * @author：THIEM
 * @create:2021/10/6-21:42
 * 这题题目有点歧义，了解dp思想即可
 */
public class leetCode746 {
    public int minCostClimbingStairs(int[] cost) {   //carl题解有点歧义
        int[] dp= new int[cost.length];
        dp[0]=cost[0];
        dp[1]=cost[1];
        for(int i=2;i<cost.length;i++){
            dp[i]= Math.min(dp[i-1],dp[i-2])+cost[i];
        }
        int ans= Math.min(dp[cost.length-1],dp[cost.length-2]);
        return ans;
    }

    public int minCostClimbingStairs1(int[] cost) {   // 官方题解这样好理解一点
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}





