package greedy_algorithm;

import java.util.Arrays;

/**
 * @author：THIEM
 * @create:2021/9/17-21:25
 * 思路2
 * 先喂饱大胃口
 * g是孩子胃口，s是饼干大小
 */
public class leetCode455_2 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);   //孩子胃口排序从小到大
        Arrays.sort(s);   //饼干大小从小到大
        int result=0;
        int s_index=s.length-1;   //最大饼干的索引
        int g_index=g.length-1;   //最大孩子的索引
        for(int i=g_index;i>=0 && s_index>=0;i--){
            if(s[s_index]>=g[i]){
                s_index--;
                result++;
            }
        }
        return result;
    }

}
