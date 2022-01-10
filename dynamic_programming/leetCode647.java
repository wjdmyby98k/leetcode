package dynamic_programming;

/**
 * @author：THIEM
 * @create:2021/11/11-20:37
 * 回文子串,s长度大于等于1
 * dp解法
 * 布尔类型的dp[i][j]：表示区间范围[i,j] （注意是左闭右闭）的子串是否是回文子串，如果是dp[i][j]为true，否则为false。
 */
public class leetCode647 {
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int result=0;
        for(int i=s.length();i>=0;i--){
            for(int j=i;j<s.length();j++){
                if(s.charAt(i)==s.charAt(j)){
                    if((j-i)<=1){
                        result++;
                        dp[i][j]=true;
                    }else if(dp[i+1][j-1]){
                        result++;
                        dp[i][j]=true;
                    }
                }
            }
        }
        return result;
    }
}
