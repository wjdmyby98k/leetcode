package dynamic_programming;

/**
 * @author：THIEM
 * @create:2021/11/12-10:13
 * dp[i][j]：字符串s在[i, j]范围内最长的回文子序列的长度为dp[i][j]。
 */
public class leetCode516 {
    public int longestPalindromeSubseq(String s) {
        int[][] dp =new int[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            dp[i][i]=1;
        }
        for (int i=s.length()-1;i>=0;i--){
            // 这里一定要初始化为j=i+1.初始化为i，会出现下面的i+1数组越界，i=j时已经初始化过了，不需要计算
            for(int j=i+1;j<s.length();j++){
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j]=dp[i+1][j-1]+2;
                }else {
                    dp[i][j]= Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][s.length()-1];
    }
}
