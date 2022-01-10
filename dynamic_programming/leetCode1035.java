package dynamic_programming;

/**
 * @author：THIEM
 * @create:2021/11/7-15:25
 * 不相交的线
 * 最长公共子序列的变种！！！
 */
public class leetCode1035 {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length+1][nums2.length+1];
        for(int i=1;i<=nums1.length;i++){
            int a=nums1[i-1];
            for(int j=1;j<=nums2.length;j++){
                int b=nums2[j-1];
                if(a==b){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[nums1.length][nums2.length];
    }
}
