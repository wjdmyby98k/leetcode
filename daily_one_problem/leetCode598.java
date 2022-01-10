package daily_one_problem;

/**
 * @author：THIEM
 * @create:2021/11/7-14:40
 */
public class leetCode598 {
    public int maxCount(int m, int n, int[][] ops) {
        if (ops.length == 0) return m * n;
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < ops.length; i++) {
            if (ops[i][0] < a) {
                a = ops[i][0];
            }
            if (ops[i][1] < b) {
                b = ops[i][1];
            }
        }
        ans = a * b;
        return ans;
    }
}
