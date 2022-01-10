package daily_one_problem;

import java.util.Arrays;

/**
 * @author：THIEM
 * @create:2021/11/20-21:56
 *  排序+双指针滑动窗口
 */
public class leetCode594 {
    public int findLHS(int[] nums) {
        int ans=0;
        Arrays.sort(nums); //这题题意是相差为1，可以排序！！！虽然改变了顺序
        for(int i=0,j=0;j<nums.length;j++){
            while(i<j && nums[j]-nums[i]>1) {
                i++;  //这一步是为了保证，i和j只差1，虽然这一步以后i可能和j一样大，但是大循环里面j还是会追上来
            }
            if(nums[j]-nums[i]==1){ //注意题意，必须最大值和最小值差值为1才算
                ans=Math.max(ans,j-i+1);
            }

        }
        return ans;
    }
}
