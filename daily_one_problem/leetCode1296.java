package daily_one_problem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author：THIEM
 * @create:2021/12/30-14:27
 * 这题和846重复
 */
public class leetCode1296 {
    public boolean isPossibleDivide(int[] nums, int k) {
        if(nums.length%k!=0) return false;
        Map<Integer,Integer> map = new HashMap<>();
        Arrays.sort(nums);
        for (int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for (int num:nums){
            if(!map.containsKey(num)) continue;
            for(int i=0;i<k;i++){
                if(!map.containsKey(num+i)) return false;
                map.put(num+i,map.get(num+i)-1);
                if (map.get(num+i)==0){
                    map.remove(num+i);
                }
            }
        }
        return true;
    }
}
