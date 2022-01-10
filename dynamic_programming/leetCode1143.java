package dynamic_programming;

/**
 * @author：THIEM
 * @create:2021/11/6-15:13
 * 最长公共子序列
 *  dp[i][j]：长度为[0, i - 1]的字符串text1与长度为[0, j - 1]的字符串text2的最长公共子序列为dp[i][j]
 */
public class leetCode1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp=new int[text1.length()+1][text2.length()+1];
        int ans=0;
        for(int i=1;i<=text1.length();i++){
            char char1=text1.charAt(i-1);
            for(int j=1;j<=text2.length();j++){
                char char2=text2.charAt(j-1);
                if(char1==char2){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
//                if(dp[i][j]>ans){
//                    ans=dp[i][j];
//                }
            }
        }
        return dp[text1.length()][text2.length()]; // 根据dp定义就是返回最大的下标
    }
}
