package hashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author：THIEM
 * @create:2021/7/22-19:53
 * 用滑动窗口做，实际上窗口就是3,这个解法运行的很慢，不太能理解
 */
public class leetCode438_2 {
    public List<Integer> findAnagrams(String s, String p) {
        char[] chars=p.toCharArray();
        Arrays.sort(chars);
//        p=new String(chars);     //p重新赋值
        List list=new ArrayList();
        for(int i=0;i<s.length()-p.length()+1;i++){
            String temp=s.substring(i,i+p.length());
            char[] chars1=temp.toCharArray();
            Arrays.sort(chars1);
            if(Arrays.equals(chars,chars1)){
                list.add(i);
            }

        }
        return list;
    }
}
