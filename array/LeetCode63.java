package array;

/**
 * @author：THIEM
 * @creat:2021/7/1-19:16
 */
public class LeetCode63 {
    public  int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int [][]dp=new int[m][n];
        for(int i=0;i<n;i++){
            if(obstacleGrid[0][i]!=1){
                dp[0][i]=1;
            }
            else {
                break;
            }
        }
        for(int j=0;j<m;j++){
            if(obstacleGrid[j][0]!=1){
                dp[j][0]=1;
            }
            else {
                break;
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(obstacleGrid[i][j]!=1) {
                    dp[i][j] += dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m-1][n-1];

    }
}
