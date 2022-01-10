package array;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author：THIEM
 * @creat:2021/7/7-19:26
 * 二分查找找左右边界(不包含target)
 */
public class LeetCode34_2 {
    @Test
    public void Test(){
        int [] nums =new int[]{1,2,3,3,3,4,5,6};
        int target=3;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }
    public int[] searchRange(int[] nums, int target) {
        int[] ans=new int[2];

        //找左边界
        int leftBorder=getLeftBorder(nums,target);
        //找右边界
        int rightBorder=getRightBorder(nums,target);
        if(rightBorder==-2 || leftBorder==-2){      //如果target不在数组中，
            return new int[]{-1,-1};
        }
        if ((rightBorder-leftBorder)>1) {
            return new int[]{leftBorder+1,rightBorder-1};

        }else{
            return new int[]{-1,-1};
        }
    }
    public int getRightBorder(int[] nums,int target){
        int left=0;
        int right=nums.length-1;
        int middle;
        int rightBorder=-2;
        while(left<=right){
            middle=left+(right-left)/2;
            if(nums[middle]>target){  // 在左边
                right=middle-1;
            }else {
                left=middle+1;
                rightBorder=left;   //这里把等于也包括了，只要找到了就把有边界设为当前位置+1；如果没找到，就是区间的有边界+1
            }
        }
        return rightBorder;
    }
    public int getLeftBorder(int[]nums,int target){
        int left=0;
        int right=nums.length-1;
        int middle;
        int leftBorder=-2;
        while(left<=right){
            middle=left+(right-left)/2;
            if(nums[middle]>=target){ // 在左边
                right=middle-1;
                leftBorder=right;
            }else {
                left=middle+1;

            }
        }
        return leftBorder;
    }
}
