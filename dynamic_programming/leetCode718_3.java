package dynamic_programming;

/**
 * @author：THIEM
 * @create:2021/11/6-11:22
 * 暴力解法，直接对两个数组遍历i,j
 * A[i:] 和 B[j:] 的最长公共前缀，直接考虑，i和j的后一位的就行了，因为两个大循环会考虑所有的对齐情况
 * 但是该方法超时了，提供一个暴力的思路
 */
public class leetCode718_3 {
    public int findLength(int[] nums1, int[] nums2) {
        int ans=0;

        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                int len= Math.min(nums1.length-i, nums2.length-j); //最短长度
                int count=0;
                for(int k=0;k<len;k++){
                    if(nums1[i+k]==nums2[j+k]){
                        count++;
                        ans= Math.max(count,ans);
                    }else {
                        count=0;
                    }

                }
            }
        }
        return ans;
    }
}
