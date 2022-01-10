package dynamic_programming;

import java.util.Arrays;

/**
 * @author：THIEM
 * @create:2021/11/4-19:20
 * 最长递增子序列
 * 子序列DP入门题
 * dp[i]表示i之前包括i的最长上升子序列。
 */
public class leetCode300 {
    public int lengthOfLIS(int[] nums) {
        int[] dp= new int[nums.length];
        Arrays.fill(dp,1); //初始化全部为1
        int ans=1;
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]= Math.max(dp[i],dp[j]+1); //递推公式的推导！
                }
                if(dp[i]>ans){  //及时更新ans
                    ans=dp[i];
                }
            }
        }
        //这里一定要用一个ans记录一下，因为dp最后一个数，不一定就是最大的值，比如1 2 3 0，最后一个i根本不会进入循环，为初始的1
        return ans;
    }
}
