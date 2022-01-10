package array;

/**
 * @author：THIEM
 * @creat:2021/7/4-21:34
 *
 */
public class LeetCode283 {
    //方法1
    public void moveZeroes(int [] nums ){
        int left=0;
        for(int right=0;right<nums.length;right++){
            if(nums[right]!=0){
                nums[left]=nums[right];
                left++;
            }
        }
        for(int i=left;i<nums.length;i++){
            nums[i]=0;
        }
//        System.out.println(Arrays.toString(nums));
    }
    //方法2
//    public static void main(String[] args) {
//        int[] nums=new int[]{1,2,3,0,0,2};
//        methodTest.moveZeroes(nums);
//    }
//    public static void moveZeroes(int[] nums) {
//        int n = nums.length, left = 0, right = 0;
//        while (right < n) {
//            if (nums[right] != 0) {
//                swap(nums, left, right);
//                left++;
//            }
//            right++;
//        }
//    }
//
//    public static void swap(int[] nums, int left, int right) {
//        int temp = nums[left];
//        nums[left] = nums[right];
//        nums[right] = temp;
//    }
}
