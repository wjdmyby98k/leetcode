package greedy_algorithm;

import java.util.Arrays;

/**
 * @author：THIEM
 * @create:2021/10/5-4:05
 * 不用贪心写.用两次排序
 */
public class leetCode1005_3 {
    public int largestSumAfterKNegations(int[] nums, int K) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0 && K>0){
                nums[i]*=-1;
                K--;
            }
        }
        if(K%2==1){
            Arrays.sort(nums);
            nums[0]*=-1;
        }
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        return sum;
    }
}
