package greedy_algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author：THIEM
 * @create:2021/10/6-14:56
 * carl图解，思路清晰
 * charAt是取索引处的字符，indexOf是第一次出现的索引
 */
public class leetCode763 {
    public List<Integer> partitionLabels(String s) {
        List<Integer> list=new ArrayList<>();
        int[] hash=new int[26];
        for(int i=0;i<s.length();i++){  // 记录字母的最远下标
            hash[s.charAt(i)-'a']=i;
        }
        int right=0;
        int left=0;
//        System.out.println(Arrays.toString(hash));
        for(int i=0;i<s.length();i++){
            right= Math.max(right,hash[s.charAt(i)-'a']); //更新最远下标
            if(right==i){    //当最远下标和当前下标相等的时候，就找到了一个分割线
                list.add(right-left+1);
                left=right+1;
            }
        }
        return list;
    }
}
