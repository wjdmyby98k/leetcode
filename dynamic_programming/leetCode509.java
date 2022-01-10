package dynamic_programming;

/**
 * @author：THIEM
 * @create:2021/10/6-19:47
 * 斐波那契数列，动态规划入门题，用递归也能做
 */
public class leetCode509 {
    public int fib(int n) {
        if(n<=1) return n;
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
