package daily_one_problem;

/**
 * @author：THIEM
 * @create:2021/12/29-15:34
 * 三叶的暴力解法
 * 时间复杂度：O(n^4)
 * 空间复杂度：O(1)
 */
public class leetCode1995 {
    public int countQuadruplets(int[] nums) {
        int n = nums.length, ans = 0;
        for (int a = 0; a < n; a++) {
            for (int b = a + 1; b < n; b++) {
                for (int c = b + 1; c < n; c++) {
                    for (int d = c + 1; d < n; d++) {
                        if (nums[a] + nums[b] + nums[c] == nums[d]) ans++;
                    }
                }
            }
        }
        return ans;
    }

}
