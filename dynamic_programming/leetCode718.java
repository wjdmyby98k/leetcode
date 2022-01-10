package dynamic_programming;

/**
 * @author：THIEM
 * @create:2021/11/5-18:40
 * dp[i][j] ：以下标i - 1为结尾的A，和以下标j - 1为结尾的B，最长重复子数组长度为dp[i][j]。
 * 为什么是i-1，j-1，个人理解是为了初始化，不然是i和j的话，因为循环开始的位置是1，对于0那些下标，还要初始化，会比较麻烦。
 */
public class leetCode718 {
    public int findLength(int[] nums1, int[] nums2) {
        int ans=0;
        int [][] dp=new int[nums1.length+1][nums2.length+1];
        for(int i=1;i<=nums1.length;i++){
            for(int j=1;j<=nums2.length;j++){
                if(nums1[i-1]==nums2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1; //  dp formula
                }
                if(dp[i][j]>ans){
                    ans=dp[i][j];
                }
            }
        }
        return ans;
    }
}
