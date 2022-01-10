package array;

/**
 * @author：THIEM
 * @creat:2021/7/9-21:09
 */
public class LeetCode34_leftBorder {
    public int leftBorder(int[] nums,int target){
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int middle=left+(right-left)/2;
            if(nums[middle]==target){
                right=middle-1;
            }
            if(nums[middle]>target){
                right=middle-1;
            }
            if(nums[middle]<target){
                left=middle+1;
            }
        }
        return nums[left+1]==target?left:-2;
    }

}
