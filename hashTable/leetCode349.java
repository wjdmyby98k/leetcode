package hashTable;

import java.util.HashSet;
import java.util.Set;

/**
 * @author：THIEM
 * @create:2021/7/22-20:15
 * 一个细节，声明set的时候，注意用泛型，这样里面的元素全是Integer，再转换成int可以直接自动拆箱，否则是object类型，不方便转换成int
 */
public class leetCode349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1==null || nums1.length==0 || nums2==null ||nums2.length==0) return new int[0];
        Set<Integer> set=new HashSet();
        Set<Integer> resSet =new HashSet();
        for (int i:nums1){
            set.add(i);
        }
        for(int i :nums2){
            if(set.contains(i)){
                resSet.add(i);
            }
        }
        int [] ans=new int[resSet.size()];
        int index=0;
        for( int i : resSet){
            ans[index++]=i;
        }
        return ans;
    }
}
