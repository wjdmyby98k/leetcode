package greedy_algorithm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author：THIEM
 * @create:2021/10/6-3:16
 * Integer.compare(o1[0],o2[0]); // 这里防止溢出，因为源码不涉及加减，只涉及到比较大小，一般的比较器都是作差
 */
public class leetCode452 {
    public int findMinArrowShots(int[][] points) {
        Comparator<int[]> comparator=(o1, o2) -> Integer.compare(o1[0],o2[0]); // 这里防止溢出
        Arrays.sort(points,comparator);   // 根据气球的左边界排序
//        System.out.println(Arrays.deepToString(points));
        int count=1;  //至少需要一个
        for(int i=1;i<points.length;i++){
            if(points[i][0]>points[i-1][1]){  //下一个气球的左边界大于前一个气球的右边界
                count++;
            }else {
                points[i][1]= Math.min(points[i-1][1],points[i][1]);
            }
        }
        return count;
    }
}
