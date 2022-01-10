package dynamic_programming;

/**
 * @author：THIEM
 * @create:2021/11/5-11:03
 * 遍历一遍，不用DP做
 */
public class leetCode674 {
    public int findLengthOfLCIS(int[] nums) {
        int ans=1;
        int temp=1;
        for(int i=1;i< nums.length;i++){
            if(nums[i]>nums[i-1]){
                temp++;
                ans= Math.max(ans,temp);
            }else {
                temp=1;
            }
        }
        return ans;
    }
}
