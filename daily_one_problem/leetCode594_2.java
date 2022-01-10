package daily_one_problem;

import java.util.HashMap;

/**
 * @author：THIEM
 * @create:2021/11/20-22:07
 * 用哈希表，好理解！
 */
public class leetCode594_2 {
    public int findLHS(int[] nums) {
        int ans=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:nums){ //将每个数字放进去，统计次数
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(int i:nums){//遍历nums，判断比他小的数在不在
            if(map.containsKey(i-1)){ //感觉这里i+1也行！但同时下面也要改成i+1
                ans= Math.max(map.get(i)+map.get(i-1),ans);
            }
        }
        return ans;
    }
}
