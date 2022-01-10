package dynamic_programming;

/**
 * @author：THIEM
 * @create:2021/11/11-16:46
 * dp[i][j]：以i-1为结尾的s子序列中出现以j-1为结尾的t的个数为dp[i][j]。
 * 这一类问题，基本是要分析两种情况
 *
 * s[i - 1] 与 t[j - 1]相等
 * s[i - 1] 与 t[j - 1] 不相等
 * 当s[i - 1] 与 t[j - 1]相等时，dp[i][j]可以有两部分组成。
 *      一部分是用s[i - 1]来匹配，那么个数为dp[i - 1][j - 1]。
 *      一部分是不用s[i - 1]来匹配，个数为dp[i - 1][j]。
 *      这里可能有同学不明白了，为什么还要考虑 不用s[i - 1]来匹配，都相同了指定要匹配啊。
 *      例如： s：bagg 和 t：bag ，s[3] 和 t[2]是相同的，但是字符串s也可以不用s[3]来匹配，即用s[0]s[1]s[2]组成的bag。
 *      当然也可以用s[3]来匹配，即：s[0]s[1]s[3]组成的bag。
 * 所以当s[i - 1] 与 t[j - 1]相等时，dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
 * 当s[i - 1] 与 t[j - 1]不相等时，dp[i][j]只有一部分组成，不用s[i - 1]来匹配，即：dp[i - 1][j]
 * 所以递推公式为：dp[i][j] = dp[i - 1][j];
 */
public class leetCode115 {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];
        for(int i=0;i<=s.length();i++){
            dp[i][0]=1;
        }
        for(int i=1;i<=s.length();i++){
            for(int j=1;j<=t.length();j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                }else {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}
