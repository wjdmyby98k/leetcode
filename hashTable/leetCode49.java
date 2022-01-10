package hashTable;

import java.util.*;

/**
 * @author：THIEM
 * @create:2021/7/15-8:54
 * 这是用排序做的，也用到了map，因为用到sort，其实是nlogn，还是很快的，比第二种解法要快
 */
public class leetCode49 {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> map= new HashMap<>();
        for(String str : strs){
            char[] array= str.toCharArray();           //将每个字符串转换成字符数组，然后排序；
            Arrays.sort(array);
            String key=new String(array);               //讲排序后的数组转换成字符串
            List<String> list = map.getOrDefault(key,new ArrayList<String>()); //按照排序后的字符串作为键，再添加
            list.add(str);
            map.put(key,list);                         //更新map，没有就添加新的key，有就更新list

        }


        return new ArrayList<>(map.values());          //最后返回map的值，利用ArrayList的构造器返回List
    }
}
