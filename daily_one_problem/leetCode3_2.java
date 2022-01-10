package daily_one_problem;

import java.util.HashSet;
import java.util.Set;

/**
 * @author：THIEM
 * @create:2021/11/24-19:46
 * 老汤视频，讲的很清楚，滑动窗口，窗口内用set维护
 */
public class leetCode3_2 {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        if(n<=1) return n;
        int maxLength=1;
        int left=0,right=0;
        Set<Character> window =new HashSet<>();
        for(;right<n;right++){  // 这里改成while也可以
            while(window.contains(s.charAt(right))){  // 这里一定要用while，因为left是要不断不断的移动的！！！
                window.remove(s.charAt(left));
                left++;
            }

            maxLength= Math.max(right-left+1,maxLength);
            window.add(s.charAt(right));
        }
        return maxLength;
    }
}
