package array;


/**
 * @author：THIEM
 * @creat:2021/7/9-20:57
 * 找不包含target的边界
 */
public class LeetCode34_rightBorder {
    public int rightBorder(int[] nums, int target){
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int middle=left+(right-left)/2;
            if(nums[middle]==target){
                left=middle+1;
            }
            if(nums[middle]>target){
                right=middle-1;
            }
            if(nums[middle]<target){
                left=middle+1;
            }
        }
        return nums[left-1]==target?left:-2;
    }
}
