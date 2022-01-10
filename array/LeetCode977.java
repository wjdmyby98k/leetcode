package array;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author：THIEM
 * @creat:2021/7/6-12:32
 * 双指针， 一个开头一个结尾
 */
public class LeetCode977 {
    @Test
    public void Test(){
        int[] nums=new int[] {-3,-2,0,4,5};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }
    public int[] sortedSquares(int[] nums) {
        int[] ans=new int[nums.length];
        int left=0;
        int right= nums.length-1;
        int index=nums.length-1;
        while(left<right){
            if(nums[right]*nums[right]<nums[left]*nums[left]){
                ans[index--]=nums[left]*nums[left];
                left++;
            }
            else{
                ans[index--]=nums[right]*nums[right];
                right--;
            }

        }
        ans[index--]=nums[left]*nums[left];
        return ans;
    }
}
