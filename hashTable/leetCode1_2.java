package hashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author：THIEM
 * @create:2021/8/5-9:38
 * 用hash表
 */
public class leetCode1_2 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> hashmap=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hashmap.containsKey(target-nums[i])){
                return new int[]{hashmap.get(target-nums[i]),i};
            }
            hashmap.put(nums[i],i);
        }
        return new int[0];
    }

}
