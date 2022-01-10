package dynamic_programming;

/**
 * @author：THIEM
 * @create:2021/11/11-19:13
 * dp[i][j] 表示以下标i-1为结尾的字符串word1，和以下标j-1为结尾的字符串word2，最近编辑距离为dp[i][j]。
 * 这几个字符串的题目都是看的carl题解，说的很清楚！
 */
public class leetCode72 {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int i=0;i<=word1.length();i++){
            dp[i][0]=i;
        }
        for(int j=0;j<=word2.length();j++){
            dp[0][j]=j;
        }
        for(int i=1;i<=word1.length();i++){
            for(int j=1;j<=word2.length();j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else {
                    // 对应三种情况，增，删，换，其中增和删是相对的，一个增就代表另一个删，最后一个是换某个字符，也是加1操作
                    dp[i][j]= Math.min(dp[i-1][j]+1, Math.min(dp[i][j-1]+1,dp[i-1][j-1]+1));
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
