package array;

/**
 * @author：THIEM
 * @creat:2021/7/7-14:54
 * 二分法，精髓就是最后循环的时候，left肯定是==right
 */
public class LeetCode704_2 {
    public int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int middle;
        while(left<=right){
            middle=(left+right)/2;
            if(nums[middle]>target){   // 在左边
                right=middle-1;
            }
            else if(nums[middle]<target){   //在右边
                left=middle+1;
            }
            else{
                return middle;
            }
        }
        return -1;
    }

}
