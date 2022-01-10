package hashTable;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author：THIEM
 * @create:2021/8/5-14:36
 * 用hash表太麻烦，用排序+双指针
 * 每个while里面都要加left<right,是为了保证不会越界，调试就会发现
 * */
public class leetCode15 {
    @Test
    public void Test(){
        int[] nums=new int[]{0,0,0};
        List list=threeSum(nums);
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0) break;  // 全大于0
            if(i>0 && nums[i]==nums[i-1]) continue; //与上一次的i重复
            int left=i+1;
            int right=nums.length-1;
            while(left<right){
                if(nums[left]+nums[right]+nums[i]==0){
                    ans.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while(left<right && nums[left]==nums[left+1]){
                        //这里都要重复left<right,是为了保证不会越界，调试发现left+1这里越界
                        left++;
                    }
                    while(left<right && nums[right]==nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }else if(nums[left]+nums[right]+nums[i]<0){
                    left++;
                }else if(nums[left]+nums[right]+nums[i]>0){
                    right--;
                }
            }
        }
        return ans;
    }
}
