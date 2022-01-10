package daily_one_problem;

/**
 * @author：THIEM
 * @create:2022/1/1-0:35
 */
public class leetCode2022 {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (m * n != original.length) return new int[][]{};
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = original[i * n + j];
            }
        }
        return ans;
    }
}
