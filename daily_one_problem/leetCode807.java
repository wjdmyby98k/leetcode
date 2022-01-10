package daily_one_problem;

/**
 * @author：THIEM
 * @create:2021/12/13-14:50
 */
public class leetCode807 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int m = grid[0].length; //n行m列
        int n = grid.length;
        int[] rMax = new int[n];
        int[] cMax = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rMax[i] = Math.max(rMax[i], grid[i][j]);  //一行一行计算行最大
                cMax[j] = Math.max(cMax[j], grid[i][j]);  // 列最大先计算出来，再不断更新
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans += Math.min(rMax[i], cMax[j]) - grid[i][j]; // 遍历到i行j列的时候
            }
        }
        return ans;
    }
}
