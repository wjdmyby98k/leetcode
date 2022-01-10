package dynamic_programming;

/**
 * @author：THIEM
 * @create:2021/10/6-22:14
 * 不同路径II
 */
public class leetCode63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length; // 行
        int n=obstacleGrid[0].length;// 列
        int[][] dp =new int[m][n];  // 初始化全部是0
        for (int i=0;i<m && obstacleGrid[i][0]!=1;i++){ // 第一列初始化，一遇到障碍物就停止循环，后面全是0
            dp[i][0]=1;
        }
        for (int j=0;j<n && obstacleGrid[0][j]!=1;j++){// 第一行初始化，一遇到障碍物就停止循环，后面全是0
            dp[0][j]=1;
        }
        for(int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                if(obstacleGrid[i][j]==1) continue;  // 遇到障碍物就跳过，默认是0
                dp[i][j]=dp[i-1][j]+dp[i][j-1];   // 即使右边是有障碍物也不要紧，因为是0
            }
        }
        return dp[m-1][n-1];
    }
}
