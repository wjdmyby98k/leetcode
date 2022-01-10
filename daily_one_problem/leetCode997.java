package daily_one_problem;

/**
 * @author：THIEM
 * @create:2021/12/19-1:30
 * 第一道图的题目，法官的入度是n-1，出度是0
 */
public class leetCode997 {
    public int findJudge(int n, int[][] trust) {
        int[] inDegrees = new int[n + 1];
        int[] outDegrees = new int[n + 1];//0-n，只取1-n下标
        for (int[] edge : trust) {
            int x = edge[0];
            int y = edge[1];
            inDegrees[y]++;
            outDegrees[x]++;
        }
        for (int i = 1; i <= n; i++) {
            if (inDegrees[i] == n - 1 && outDegrees[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
