package greedy_algorithm;

import java.util.Arrays;

/**
 * @author：THIEM
 * @create:2021/9/17-21:07
 * g是孩子胃口，s是饼干大小
 * 思路1：
 * 优先喂饱小胃口
 */
public class leetCode455 {
    public int findContentChildren(int[] g, int[] s) {
        int result=0;
        int index=0;
        Arrays.sort(g);
        Arrays.sort(s);
        for(int i=0;i<s.length && index<g.length;i++){
            if(s[i]>=g[index]){
                index++;
                result++;
            }
        }
        return result;
    }
}
