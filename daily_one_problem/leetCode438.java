package daily_one_problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author：THIEM
 * @create:2021/11/28-15:00
 * 这题写过，用hashmap时间复杂度太高了，会超时
 */
public class leetCode438 {
//    public List<Integer> findAnagrams(String s, String p) {
//        int n=p.length();
//        List<Integer> list = new LinkedList<>();
//        HashMap<Character,Integer> map1=new HashMap<>();
//        HashMap<Character,Integer> map2= new HashMap<>();
//        for(int i=0;i<p.length();i++){
//            map1.put(p.charAt(i),map1.getOrDefault(p.charAt(i),0)+1);
//        }
//        for(int i=0;i<s.length()-p.length()+1;i++){
//            map2.clear();
//            for (int j=0;j<n;j++){
//                map2.put(s.charAt(j+i),map2.getOrDefault(s.charAt(j+i),0)+1);
//            }
//            if(map1.equals(map2)){
//                list.add(i);
//            }
//
//        }
//    return list;
//    }
    public List<Integer> findAnagrams(String s, String p) {
        char[] chars=p.toCharArray();
        Arrays.sort(chars);
//        p=new String(chars);     //p重新赋值
        List<Integer> list=new ArrayList();
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
