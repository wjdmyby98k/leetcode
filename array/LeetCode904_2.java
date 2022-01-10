package array;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author：THIEM
 * @creat:2021/7/6-20:41
 */
public class LeetCode904_2 {
    @Test
    public void Test(){
        int[] nums=new int[]{3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(totalFruit(nums));
    }
    public int totalFruit(int[] fruits){
        int i=0; //起点
        int ans=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int j=0;j<fruits.length;j++){   //j是终点
            map.put(fruits[j],map.getOrDefault(fruits[j],0)+1);
            while(map.size()>=3){
                map.put(fruits[i],map.get(fruits[i])-1);
                if(map.get(fruits[i])==0){
                    map.remove(fruits[i]);
                }
                i++;

            }
            ans= Math.max(ans,j-i+1);

        }

        return ans;
    }

}
