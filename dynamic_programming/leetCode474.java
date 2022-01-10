package dynamic_programming;

/**
 * @author：THIEM
 * @create:2021/10/27-14:05
 * 动态规划永远不会写，这题算难题了
 */
public class leetCode474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp =new int[m+1][n+1];
        for(String str:strs){
            int zeroNum=0;
            int oneNum=0;
            for(char c:str.toCharArray()){
                if(c=='0'){
                    zeroNum++;
                }else{
                    oneNum++;
                }
            }
            for(int i=m;i>=zeroNum;i--){
                for(int j=n;j>=oneNum;j--){
                    dp[i][j]= Math.max(dp[i][j],dp[i-zeroNum][j-oneNum]+1);
                }
            }
        }
        return dp[m][n];
    }
}
