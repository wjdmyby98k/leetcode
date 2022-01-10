package dynamic_programming;

/**
 * @author：THIEM
 * @create:2021/10/7-14:03
 * 总感觉这题要数学证明
 */
public class leetCode343 {
    public int integerBreak(int n) {
        if(n==2) return 1;
        if (n==3) return 2;
        int[] dp= new int[n+1];
        dp[2]=1;
        dp[3]=2;
        for(int i=4;i<=n;i++){
            for(int j=1;j<i;j++){   // 这里初始化j=1 时候，dp[1]其实是没意义的，是0
                dp[i]=Math.max(dp[i], Math.max(dp[j] * (i - j), j * (i - j)));
            }
        }
        return dp[n];
    }
}
