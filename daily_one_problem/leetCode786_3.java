package daily_one_problem;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author：THIEM
 * @create:2021/11/30-15:07
 * 方法二遍历了所有的数据，其实我们只需要每次按照由小到大的顺序加入队列，然后弹出k次
 * 上面这个思路我理解错了，下面注释的是错的，保证只操作k次，就要保证每次放入最小堆的元素，是慢慢增大的，必须保证顺序！
 */
public class leetCode786_3 {
    @Test
    public void test1(){
        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b)->a[0]*b[1]-a[1]*b[0]); //最小堆
        pq.add(new int[]{1,3});
        pq.add(new int[]{2,4});
        pq.add(new int[]{1,5});
        System.out.println(Arrays.toString(pq.peek()));
    }
    // 这里优先级队列是放的索引！！！
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        if(arr.length==2) return  arr;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b)->arr[a[0]]*arr[b[1]]-arr[a[1]]*arr[b[0]]); //最小堆
        for(int i=1;i<arr.length;i++){ // 先把所有1开头的全加进去,然后在这个基础上，每次增大一点点，注意一定要是加的索引！！！
            pq.add(new int[]{0,i});
        }
        while (k!=1){
            int[] frac = pq.poll(); // 每次弹出最小的索引
            int x = frac[0], y = frac[1];
            if(x+1<y){ // 往大取一点点
                pq.add(new int[]{x+1,y});
            }
            k--;
        }
        return new int[]{arr[pq.peek()[0]],arr[pq.peek()[1]]};
    }


//    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
//        if(arr.length==2) return  arr;
//        PriorityQueue<int[]> priorityQueue=new PriorityQueue<>((a, b)->a[0]*b[1]-a[1]*b[0]); //最小堆
//        for(int i=1;i<arr.length;i++){ // 先把所有1开头的全加进去
//            priorityQueue.add(new int[]{arr[0],arr[i]});
//        }
//        int cnt=0;
//        for(int j=arr.length-2;j>0;j--){
//            for (int i=0;i<arr.length;i++){
//                double temp=1.0*arr[i]/arr[j];
//                if(1.0*priorityQueue.peek()[0]/priorityQueue.peek()[1]<temp){
//                    priorityQueue.poll();
//                    priorityQueue.add(new int[]{arr[i],arr[j]});
//                    cnt++;
//                    if(cnt==k-1) return priorityQueue.peek();
//                }
//
//            }
//        }
//        return priorityQueue.peek();
//    }
}
