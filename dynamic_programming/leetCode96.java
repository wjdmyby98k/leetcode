package dynamic_programming;

/**
 * @author：THIEM
 * @create:2021/10/7-14:23
 * 感觉又是个智力题
 */
public class leetCode96 {
    public int numTrees(int n) {
        if(n==1) return 1;
        if(n==2) return 2;
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            for(int j=0;j<i;j++){
                dp[i]+=dp[j]*dp[i-1-j];
            }
        }
        return dp[n];
    }
}
