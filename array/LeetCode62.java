package array;

/**
 * @author：THIEM
 * @creat:2021/7/1-11:39
 * 这两题不难
 */
public class LeetCode62 {
    public static int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            dp[i][0]=1;
        }
        for(int i=0;i<n;i++){
            dp[0][i]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
                System.out.println("dp["+i+"]"+"dp["+j+"]"+dp[i][j]);
            }
        }
        return 0;
    }
    public static int uniquePaths1d(int m, int n) {
        int[]dp=new int[n];
        for(int i=0;i<n;i++){
            dp[i]=1;
        }
        for(int j=1;j<n;j++){
            for(int i=1;i<m;i++){
                dp[i]+=dp[i-1];
                System.out.println("dp["+i+"]"+dp[i]);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int a= uniquePaths1d(3,7);
    }
}
