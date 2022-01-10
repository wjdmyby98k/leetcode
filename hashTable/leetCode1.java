package hashTable;

/**
 * @author：THIEM
 * @create:2021/8/5-9:32
 * 暴力循环，注意第二个循环从i+1开始
 */
public class leetCode1 {
    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }
}
