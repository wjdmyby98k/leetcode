package array;

/**
 * @author：THIEM
 * @creat:2021/7/4-20:50
 * 这个左指针与右指针的值比较，27是用右指针来比较，注意区别
 */
public class LeetCode26 {
    public int removeDuplicates(int[] nums) {
        int left=0;

        for(int right=0;right<nums.length; right++){
            if(nums[left]!=nums[right]){
                nums[++left]=nums[right];
            }
        }
        return left+1;

    }
}
