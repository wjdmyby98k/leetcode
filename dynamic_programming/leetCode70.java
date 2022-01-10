package dynamic_programming;

/**
 * @author：THIEM
 * @create:2021/10/6-20:32
 * 动态规划，爬楼梯，也是入门题
 */
public class leetCode70 {
    public int climbStairs(int n) {
        if(n==1) return 1;
        if(n==2) return 2;
        int[] dp=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for (int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}

