package array;

/**
 * @author：THIEM
 * @creat:2021/7/7-15:51
 * 找到的话就直接返回middle，找不到的时候，最后的区间肯定是left=right=middle，如果放在左边的话，right是要--的，此时返回left或者right+1就行
 * 如果放在右边的话，left是要++的，所以放在left++以后的left就行，或者直接返回right+1；
 */
public class LeetCode35 {
    public int searchInsert(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int middle;

        while(left<=right){
            middle=left+(right-left)/2;
            if(nums[middle]>target){
                right=middle-1;
            }else if(nums[middle]< target){
                left=middle+1;
            }else{
                return middle;
            }

        }

        return left;
        }
}
