package dynamic_programming;

/**
 * @author：THIEM
 * @create:2021/11/11-14:26
 * dp[i][j]：长度为[0, i - 1]的字符串text1与长度为[0, j - 1]的字符串text2的最长公共子序列为dp[i][j]
 * 这题和1143类似,长度为[0,i-1]就相当于以下标i-1为结尾的字符串
 */
public class leetCode392 {
    public boolean isSubsequence(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];
        for(int i=1;i<=s.length();i++){
            char char1=s.charAt(i-1);
            for(int j=1;j<=t.length();j++){
                char char2=t.charAt(j-1);
                if(char1==char2){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    dp[i][j]= dp[i][j-1]; //这里用1143的math.max也可以
                }
            }
        }
        return dp[s.length()][t.length()]==s.length();
    }
}
