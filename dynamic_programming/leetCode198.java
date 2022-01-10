package dynamic_programming;

/**
 * @author：THIEM
 * @create:2021/11/2-11:10
 * 打家劫舍I
 */
public class leetCode198 {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);
        int[] dp =new int[nums.length];
        dp[0]=nums[0]; // 初始化
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            dp[i]= Math.max(dp[i-2]+nums[i],dp[i-1]); //这个状态方程还是比较容易想到的
        }
        return dp[nums.length-1];
    }
}
