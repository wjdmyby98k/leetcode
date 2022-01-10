package daily_one_problem;

/**
 * @author：THIEM
 * @create:2021/12/13-15:16
 * 线性查找， 不使用额外空间，只有异或！！！
 */
public class leetCode136 {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans ^= nums[i];
        }
        return ans;
    }
}
