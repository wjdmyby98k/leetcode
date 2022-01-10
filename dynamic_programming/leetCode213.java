package dynamic_programming;

/**
 * @author：THIEM
 * @create:2021/11/2-11:27
 * 打家劫舍II
 * 考虑收尾，分开考虑就行，一个包括首，一个包含尾
 */
public class leetCode213 {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);
        int ans1=robRange(nums,0,nums.length-2);
        int ans2=robRange(nums,1,nums.length-1);
        return Math.max(ans1,ans2);
    }
    public int robRange(int[] nums,int start,int end){ //这里是前闭后闭
        int[] dp =new int[nums.length];
        dp[start]=nums[start]; // 初始化
        dp[start+1]=Math.max(nums[start],nums[start+1]);
        for(int i=start+2;i<=end;i++){
            dp[i]= Math.max(dp[i-2]+nums[i],dp[i-1]); //这个状态方程还是比较容易想到的
        }
        return dp[end]; //不是end-1，注意区间
    }
}
