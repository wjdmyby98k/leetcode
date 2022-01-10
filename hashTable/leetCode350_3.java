package hashTable;

import java.util.Arrays;

/**
 * @author：THIEM
 * @create:2021/7/23-10:00
 * 如果数组有序，用双指针
 */
public class leetCode350_3 {
    public static int[] intersect(int[] nums1, int[] nums2) {
        if(nums1==null ||nums1.length==0 || nums2==null || nums2.length==0) return new int[0];
        if(nums1.length>nums2.length){
            int [] temp=nums1;
            nums1=nums2;
            nums2=temp;
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);  //nums1 is shorter
        int slow =0;
        int fast =0;
        int[] ans=new int[nums1.length];     // create a array according to nums1
        int index=0;     //record data and position
        while(slow<nums1.length && fast<nums2.length){
            if(nums1[slow]<nums2[fast]){
                slow++;
            }else if(nums1[slow]==nums2[fast]){
                ans[index++]=nums1[slow];
                slow++;
                fast++;
            }else {
                fast++;
            }
        }
        return Arrays.copyOfRange(ans,0,index);
    }
}
