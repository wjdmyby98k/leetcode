package dynamic_programming;

import java.util.Arrays;

/**
 * @author：THIEM
 * @create:2021/10/31-16:52
 */
public class leetCode279 {
    public int numSquares(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=0;i*i<=n;i++){
            for(int j=0;j<=n;j++){
                if(j>=i*i && dp[j-i*i]!=Integer.MAX_VALUE){
                    dp[j]= Math.min(dp[j],dp[j-i*i]+1);
                }

            }
        }
        return dp[n];
    }
}
