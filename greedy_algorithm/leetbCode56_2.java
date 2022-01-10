package greedy_algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author：THIEM
 * @create:2021/10/6-16:01
 */
public class leetbCode56_2 {
    public int[][] merge(int[][] intervals) {
        List<int[]> list=new LinkedList<>();
        Arrays.sort(intervals,(o1, o2) -> Integer.compare(o1[0],o2[0])); // 只对左边界排序就够了
        if(intervals.length==1) return intervals;
        int start=intervals[0][0];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]>intervals[i-1][1]){
                list.add(new int[]{start,intervals[i-1][1]});
                start=intervals[i][0];
            }else {
                intervals[i][1]=Math.max(intervals[i-1][1],intervals[i][1]);
            }
        }
        int n=intervals.length;
        //实际上下面这一步是可以合并的，右边界都是一样，无非就是左边界
        if(intervals[n-1][0]>intervals[n-2][1]){
            list.add(intervals[n-1]);
        }else {
            list.add(new int[]{start,intervals[n-1][1]});
        }
        return list.toArray(new int[list.size()][]);
    }

}
