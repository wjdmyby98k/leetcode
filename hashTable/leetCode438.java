package hashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author：THIEM
 * @create:2021/7/15-8:56
 * 思路：new两个数组，都放入p个长度的字符串，然后固定窗口，存放s字符串的那个数组每次增一个删一个，看看是否和放p的数组一样
 */
public class leetCode438 {
    public List<Integer> findAnagrams(String s, String p) {
        int[] cnt_s=new int[26];
        int[] cnt_p=new int[26];
        int n=s.length();
        int m=p.length();
        List ans=new ArrayList();
        if(n<m) return ans;

        for(int i=0;i<p.length();i++){
            cnt_s[s.charAt(i)-'a']++;
            cnt_p[p.charAt(i)-'a']++;
        }
        if(Arrays.equals(cnt_p,cnt_s)){
            ans.add(0);
        }
        for(int i=m;i<n;i++){
            cnt_s[s.charAt(i-m)-'a']--;
            cnt_s[s.charAt(i)-'a']++;
            if(Arrays.equals(cnt_p,cnt_s)){
                ans.add(i-m+1);
            }
        }
        return ans;
    }
}

