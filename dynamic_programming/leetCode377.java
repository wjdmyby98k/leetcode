package dynamic_programming;

/**
 * @author：THIEM
 * @create:2021/10/28-20:12
 * 这题和518，一个是排列，一个是组合,不用dp的话，就直接暴力回溯，道理都是一样的
 */
public class leetCode377 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp=new int[target+1];
        dp[0]=1;
        for(int j=0;j<=target;j++){
            for(int i=0;i<nums.length;i++){
                if(j>=nums[i]){
                    dp[j]+=dp[j-nums[i]];
                }
            }
        }
        return dp[target];
    }
}
