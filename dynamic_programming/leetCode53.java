package dynamic_programming;

/**
 * @author：THIEM
 * @create:2021/11/11-14:20
 * dp[i]表示为包含下标i之前的最大连续子序列和
 */
public class leetCode53 {
    public int maxSubArray(int[] nums) {
        int[] dp= new int[nums.length];
        int result=nums[0];
        dp[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i]= Math.max(dp[i-1]+nums[i],nums[i]);  // 递推公式
            if(dp[i]>result){
                result=dp[i];
            }
        }
        return result;
    }
}
