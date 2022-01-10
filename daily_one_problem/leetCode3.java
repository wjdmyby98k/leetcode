package daily_one_problem;

import java.util.HashMap;

/**
 * @author：THIEM
 * @create:2021/11/24-14:58
 * 滑动窗口思想，这个滑动窗口感觉不太好理解，用set会好理解一点
 * 老汤也讲了这个，是方法二的优化版本，用hashmap记录索引！从一步一步移动，到只需要一步移动
 */
public class leetCode3 {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        int ans=1;
        HashMap<Character,Integer> hashMap=new HashMap<>();
        int left=0;
        for(int i=0;i<s.length();i++){
            if(hashMap.containsKey(s.charAt(i))){
                left= Math.max(left,hashMap.get(s.charAt(i))+1); // 以前的那个下标+1,一定要跟left比较一下，注意+1的位置
                // abba举例就懂了，遍历到第二个a，left要比较一下 ，或者  abcba  左指针不是所有情况都要移动的！
            }
            hashMap.put(s.charAt(i),i);
            ans=Math.max(ans,i-left+1);
        }
        return ans;
    }
}
