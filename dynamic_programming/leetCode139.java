package dynamic_programming;

import java.util.List;

/**
 * @author：THIEM
 * @create:2021/11/1-19:35
 * 先物品后背包好像不好写啊
 */
public class leetCode139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp=new boolean[s.length()+1];
        dp[0]=true;
        for(int j=1;j<=s.length();j++){ //遍历背包
            for(int i=0;i<j;i++){ // 遍历物品
                if(dp[i]==true && wordDict.contains(s.substring(i,j))){
                    dp[j]=true;
                }
            }
        }
        return dp[s.length()];
    }

}
