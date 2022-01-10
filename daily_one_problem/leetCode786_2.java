package daily_one_problem;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author：THIEM
 * @create:2021/11/30-14:11
 * 优先级队列
 * 但是这里是把元素全部加进去了！每个外循环开始的i加进去的值最大，然后依次减小
 * 维护一个最大堆，个数为k，然后取最后一个元素！
 * 升序最小堆，降序最大堆
 */
public class leetCode786_2 {
    @Test
    public void test1(){
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)-> Double.compare(1.0*a[0]*b[1],1.0*a[1]*b[0]));
        pq.add(new int[]{1,3});
        pq.add(new int[]{1,5});
        System.out.println(Arrays.toString(pq.peek())); // [1,5]是最小堆

    }
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        if(arr.length==2) return  arr;
        PriorityQueue<int[]> priorityQueue=new PriorityQueue<>((a,b)-> Double.compare(1.0*a[1]*b[0],1.0*a[0]*b[1]));
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                double temp=1.0*arr[i]/arr[j];
                if(priorityQueue.size()<k){
                    priorityQueue.add(new int[]{arr[i],arr[j]});
                }else {
                    if(1.0*priorityQueue.peek()[0]/priorityQueue.peek()[1]>temp){
                        priorityQueue.poll();
                        priorityQueue.add(new int[]{arr[i],arr[j]});
                    }
                }
//                System.out.println(Arrays.toString(priorityQueue.peek()));

            }
        }
        return priorityQueue.peek();
    }
}
