package greedy_algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author：THIEM
 * @create:2021/10/6-15:31
 * 方法一，先把第一个元素加进去，不过这样是浅拷贝，list里面的数组是intervals的引用
 */
public class leetCode56 {
    public int[][] merge(int[][] intervals) {
        List<int[]> list=new ArrayList<>();
        Comparator<int[]> comparator=new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return Integer.compare(o1[1],o2[1]);
                }
                return Integer.compare(o1[0],o2[0]);
            }
        };
        Arrays.sort(intervals,comparator);  // 左边界排序
        list.add(intervals[0]);  //先把第一个元素加进去
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]>intervals[i-1][1]){   // 如果当前左边界大于前一个右边界，就把当前加进去
                list.add(intervals[i]);
            }else {         // 否则，要合并，把前面一个移除，再合并
                intervals[i][0]=intervals[i-1][0];
                intervals[i][1]= Math.max(intervals[i-1][1],intervals[i][1]);
                list.remove(list.size()-1);
                list.add(intervals[i]);
            }

        }
        return list.toArray(new int[list.size()][]);
    }
}
