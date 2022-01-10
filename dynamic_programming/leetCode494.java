package dynamic_programming;

/**
 * @author：THIEM
 * @create:2021/10/26-10:13
 * 这题hard不为过，多看看carl题解
 * 这道题目咋眼一看和动态规划背包啥的也没啥关系。
 *
 * 本题要如何使表达式结果为target，
 *
 * 既然为target，那么就一定有 left组合 - right组合 = target。
 *
 * left + right等于sum，而sum是固定的。
 *
 * 公式来了， left - (sum - left) = target -> left = (target + sum)/2 。
 *
 * target是固定的，sum是固定的，left就可以求出来。
 *
 * 此时问题就是在集合nums中找出和为left的组合。
 * dp[j] += dp[j - nums[i]]（遍历到nums[i]时，
 * dp[j]就等于没给nums[i]时装满j容量背包的方法数  加上  装满j-nums[i]容量背包的方法数(此时装入nums[i])就装满j容量了）
 */
public class leetCode494 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if((sum+target)%2==1) return 0; // 此时没有方案
        if(target>sum) return 0; // 此时没有方案
        int bagSize=(sum+target)/2;
        if(bagSize<0){
            bagSize=-bagSize;
        }
        int[] dp= new int[bagSize+1];
        dp[0]=1; // 初始化为1，方便累加
        for(int i=0;i<nums.length;i++){
            for(int j=bagSize;j>=nums[i];j--){
                dp[j]+=dp[j-nums[i]];
            }
        }
        return dp[bagSize];
    }
}
