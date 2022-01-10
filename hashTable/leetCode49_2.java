package hashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author：THIEM
 * @create:2021/7/21-19:22
 * 键考虑用字母和出现的次数组合的形式
 */
public class leetCode49_2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for(String str : strs){
            int[] count=new int[26];
            for(int i=0;i<str.length();i++){
                count[str.charAt(i)-'a']++;
            }
            StringBuilder sb =new StringBuilder();
            for(int i=0;i<count.length;i++){
                if(count[i]>0){
                    sb.append((char)(i +'a'));
                    sb.append(count[i]);
                }
            }
            String key=sb.toString();
            List<String> list=map.getOrDefault(key,new ArrayList<String>());
            list.add(str);
            map.put(key,list);
        }

        return new ArrayList<>(map.values());
    }
}
