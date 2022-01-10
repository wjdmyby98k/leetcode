package array;

/**
 * @author：THIEM
 * @creat:2021/7/9-16:12
 * 自己写一个分开的逻辑，前面的都分成2个逻辑了，这里用3个
 */
public class LeetCode34_3 {
    public int[] searchRange(int[] nums, int target){
        if(nums.length==0) return new int[]{-1,-1};

        int leftBorder=leftBinarySearch(nums,target);
        int rightBorder=rightBinarySearch(nums,target);
        //不在范围内or不存在
        if(leftBorder==-2 || rightBorder==-2) {
            return new int[]{-1, -1};
        }
        //在范围内且存在
        return new int[]{leftBorder+1,rightBorder-1};
    }
    // leftBorder
    public int leftBinarySearch(int[] nums,int target){
        int left=0;
        int right=nums.length-1;
        if(target<nums[0] || target>nums[nums.length-1]){    //如果不包含，直接返回-2
            return -2;
        }
        while(left<=right){
            int middle=left+(right-left)/2;
            if(nums[middle]==target){      //因为要要左边界，==时候肯定要找让right=middle-1
                right=middle-1;
            }
            if(nums[middle]<target){
                left=middle+1;
            }
            if(nums[middle]>target){
                right=middle-1;
            }
        }
        return nums[right+1]==target?right:-2;   //因为是找左边界，所以要从左边区间开始找，然后不断逼近right返回

    }
    // rightBorder
    public int rightBinarySearch(int []nums,int target){
        int left=0;
        int right =nums.length-1;
        if(target<nums[0] || target>nums[nums.length-1]){    //如果不包含，直接返回-2
            return -2;
        }
        while(left<=right){
            int middle=left+(right-left)/2;
            if(nums[middle]==target){
                left=middle+1;
            }
            if(nums[middle]<target){
                left=middle+1;
            }
            if(nums[middle]>target){
                right=middle-1;
            }
        }
        return nums[left-1]==target?left:-2;

    }

}
