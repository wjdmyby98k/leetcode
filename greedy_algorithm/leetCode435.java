package greedy_algorithm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author：THIEM
 * @create:2021/10/6-13:57
 * 贪心思想:左排序，每次选择最小的有边界
 */
public class leetCode435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length<2) return 0;
        int count=0;
        Comparator<int[]> comparator=new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0],o2[0]);
            }
        };
        Arrays.sort(intervals,comparator);  //左排序
        for(int i=1;i<intervals.length;i++){
            if(intervals[i-1][1]>intervals[i][0]){  // 有重叠，就移除
                intervals[i][1]= Math.min(intervals[i-1][1],intervals[i][1]);
                count++;
            }
        }
        return count;
    }
}
