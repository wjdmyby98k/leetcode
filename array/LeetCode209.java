package array;

import org.junit.Test;

/**
 * @author：THIEM
 * @creat:2021/7/6-14:07
 * target和nums全是正的
 */
public class LeetCode209 {
    @Test
    public void Test(){
        int[] nums=new int[]{2,3,1,2,4,3};
        System.out.println(violence(7, nums));
    }
    public int minSubArrayLen(int target, int[] nums) {
        int result=Integer.MAX_VALUE;
        int left=0;
        int sum=0;
        int right=0;
        for(right=0;right<nums.length;right++){
            sum+=nums[right];
            while(sum>=target){
                result= Math.min(result,right-left+1);
                sum-=nums[left++];
            }
        }
        if(result==Integer.MAX_VALUE){
            result=0;
        }
        return result;

    }
    public int violence(int target, int[] nums){
        int result= Integer.MAX_VALUE;
        int sum;
        for(int i=0;i<nums.length;i++){ //start
            sum=0;
            for(int j=i;j<nums.length;j++){  //stop
                sum+=nums[j];
                if(sum>=target){
                    result= Math.min(result,j-i+1);
                    break;
            }
            }
        }
        if(result==Integer.MAX_VALUE){
            result=0;
        }
        return result;
    }
}
