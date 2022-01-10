package stack_and_queue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author：THIEM
 * @create:2021/8/17-0:40
 * lambda表达式就是匿名实现类
 */
public class leetCode347 {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans=new int[k];
        Map<Integer,Integer> map=new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);//模板写法
        }
        Set<Map.Entry<Integer,Integer>> entries=map.entrySet();//得到map的每个entry
        //建立一个优先级队列
        PriorityQueue<Map.Entry<Integer,Integer>> queue=new PriorityQueue<>((o1, o2) -> o1.getValue()-o2.getValue());
        //把每个entry取出来加入到优先级队列里面，并按照value从小到大排序，队列只维护k个entry
        for(Map.Entry<Integer,Integer> entry:entries){
            queue.offer(entry);
            if(queue.size()>k){
                queue.poll();
            }
        }
        for(int i=0;i<k;i++){  //此时队列里的k个entry的值，就是频次最大的前k个
            ans[i]=queue.poll().getKey();
        }
        return ans;
    }
}
