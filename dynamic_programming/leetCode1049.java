package dynamic_programming;

/**
 * @author：THIEM
 * @create:2021/10/25-19:34 转换成背包问题，不用考虑中间是怎么操作的，只分成最接近的两堆就行
 */
public class leetCode1049 {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int i = 0; i < stones.length; i++) {
            sum += stones[i];
        }
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - dp[target] - dp[target];//一堆是dp[target],另一堆是sum-dp[target]
    }
}
