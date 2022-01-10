package daily_one_problem;

/**
 * @author：THIEM
 * @create:2021/11/23-20:59 简单题，三叶的额外题
 */
public class leetCode1480 {
    public int[] runningSum(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0, s = 0; i < nums.length; i++) {
            s += nums[i];
            ans[i] = s;
        }
        return ans;
    }
}
