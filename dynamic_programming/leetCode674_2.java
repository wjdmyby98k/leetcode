package dynamic_programming;

import java.util.Arrays;

/**
 * @author：THIEM
 * @create:2021/11/5-16:15
 * dp[i]：以下标i为结尾的数组的连续递增的子序列长度为dp[i]。
 */
public class leetCode674_2 {
    public int findLengthOfLCIS(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,1);
        int ans=1;
        for(int i=1;i< nums.length;i++){
            if(nums[i]>nums[i-1]){
                dp[i]=dp[i-1]+1;
            }
            if(dp[i]>ans){
                ans=dp[i];
            }
        }
        return ans;
    }
}
