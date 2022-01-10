package daily_one_problem;

import java.util.HashSet;

/**
 * @author：THIEM
 * @create:2021/11/6-14:49
 */
public class leetCode268 {
    public int missingNumber(int[] nums) {
//        int n=nums.length;
        int missing=0;
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i=0;i<nums.length;i++){ // 先遍历一遍放入hashset
            hashSet.add(nums[i]);
        }
        for(int i=0;i<=nums.length;i++){ // 再遍历一遍0-n。看看哪个不在hashset里面
            if(!hashSet.contains(i)){
                missing=i;
            }
        }
        return missing;
    }
}
