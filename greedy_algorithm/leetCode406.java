package greedy_algorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * @author：THIEM
 * @create:2021/10/6-1:48
 * Arrays.toString打印数组，Arrays.deepToString打印二维数组
 * toArray有个重载，带参和不带参,不带参返回的是Object[],带参可以返回指定类型，
 */
public class leetCode406 {
    public int[][] reconstructQueue(int[][] people) {
        Comparator<int[]> comparator=new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }
                return o2[0]-o1[0];
            }
        };
        Arrays.sort(people,comparator);
        LinkedList<int[]> list=new LinkedList<>();
        for(int[] p:people){
            list.add(p[1],p);
        }
        return list.toArray(new int[people.length][]);  //创建一个匿名数组，而下面则是直接在people上面修改
//        int[][] ans=list.toArray(people);
//        return ans;
    }
}

