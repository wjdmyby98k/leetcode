package dynamic_programming;

/**
 * @author：THIEM
 * @create:2021/11/6-10:40
 * 用滑动窗口写，不是常规的滑动窗口
 */
public class leetCode718_2 {
    public int findLength(int[] nums1, int[] nums2) {
        if(nums1.length<nums2.length){
            return findLengthHelper(nums1,nums2);
        }
        return findLengthHelper(nums2,nums1);
    }
    public int findLengthHelper(int[] A, int[] B) {  // A是短的那个
        // 总的滑动步数
        int total=B.length+A.length-1;
        int max=0;
        for(int i=0;i<total;i++){
            int aStart=0;
            int bStart=0;
            int len=0; // 这一轮窗口的长度
            if(i<A.length){ // A还没有完全进入
                aStart=A.length-i-1;
                bStart=0;
                len=i+1;
            }else {  // A完全进入，包括A出去的时候
                aStart=0;
                bStart=i-A.length+1;
                len= Math.min(B.length-bStart, A.length);
            }
            max= Math.max(max,maxLength(A,B,aStart,bStart,len));
        }
        return max;
    }
    public int maxLength(int[] A, int[] B, int aStart, int bStart, int len) { //对每个窗口，求最长长度
        int count=0;
        int ans=0;
        for(int i=0;i<len;i++){
            if(A[aStart+i]==B[bStart+i]){
                count++;
                ans= Math.max(ans,count);
            }else {
                count=0;
            }
        }
        return ans;
    }
}
