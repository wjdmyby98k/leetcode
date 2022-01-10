package array;

/**
 * @author：THIEM
 * @creat:2021/7/4-16:35
 * 具体看力扣解法
 */
public class LeetCode96 {
    public int numTrees(int n) {
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            for(int j=1;j<=i;j++){
                dp[i]+=dp[j-1]*dp[i-j];
            }
        }
        return dp[n];

    }
}
