package hashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author：THIEM
 * @create:2021/7/22-20:15
 * 一个细节，声明set的时候，注意用泛型，这样里面的元素全是Integer，再转换成int可以直接自动拆箱，否则是object类型，不方便转换成int
 */
public class leetCode350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1==null || nums1.length==0 || nums2==null || nums2.length==0) return new int[0];
        Map<Integer,Integer> map=new HashMap<>();
        if(nums1.length>nums2.length){
            int[] temp=nums1;
            nums1=nums2;
            nums2=temp;
        }
        for(int i: nums1){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else {
                map.put(i,1);
            }
        }
        List<Integer> list =new ArrayList();
        for(int i:nums2){
            if(map.containsKey(i)){
                if(map.get(i)>0){
                    map.put(i,map.get(i)-1);
                    list.add(i);
                }
            }
        }
        int[] ans=new int[list.size()];
        for(int i=0;i<list.size();i++){
            ans[i]=list.get(i);
        }

        return ans;
    }
}
