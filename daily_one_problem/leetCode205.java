package daily_one_problem;

import java.util.HashMap;
import java.util.Map;

/**
 * @author：THIEM
 * @create:2021/12/21-21:24
 * 可以假设 s 和 t 长度相同。
 */
public class leetCode205 {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> map1=new HashMap<>();
        Map<Character,Character> map2=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(!map1.containsKey(s.charAt(i))){ // 如果不含键，才添加映射
                map1.put(s.charAt(i),t.charAt(i));
            }
            if(!map2.containsKey(t.charAt(i))){
                map2.put(t.charAt(i),s.charAt(i));
            }
            // 无法映射，返回false
            if(map1.get(s.charAt(i))!=t.charAt(i) || map2.get(t.charAt(i))!=s.charAt(i)){
                return false;
            }
        }
        return true;
    }
}
