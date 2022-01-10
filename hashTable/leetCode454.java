package hashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author：THIEM
 * @create:2021/8/5-10:23
 */
public class leetCode454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer,Integer> hashmap =new HashMap<>();
        int ans=0;
        for(int i : A){
            for(int j : B){
                int count=i+j;
                hashmap.put(count,hashmap.getOrDefault(count,0)+1);
            }
        }
        for(int i: C){
            for(int j: D){
                int count=i+j;
                if(hashmap.containsKey(-count)){
                    ans+=hashmap.get(-count);
                }
            }
        }
        return ans;
    }
}
