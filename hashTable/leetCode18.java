package hashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author：THIEM
 * @create:2021/8/5-16:07
 * 这是也是四数之和，但是和454不一样，这里不允许重复
 */
public class leetCode18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list =new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;//相等说明重复了，跳过
            for(int j=i+1;j<nums.length;j++){
                if(j>i+1 && nums[j]==nums[j-1]) continue;//同上
                int left=j+1;
                int right=nums.length-1;
                while(left<right){
                    if(nums[i]+nums[j]+nums[left]+nums[right]==target){
                        list.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        //开始剪枝，去除双指针重复的数字
                        while(left<right && nums[left]==nums[left+1]) left++;
                        while(left<right && nums[right]==nums[right-1]) right--;
                        //双指针去除重复以后，再缩小双指针
                        right--;
                        left++;
                    }else if(nums[i]+nums[j]+nums[left]+nums[right]>target){
                        right--;
                    }else if(nums[i]+nums[j]+nums[left]+nums[right]<target){
                        left++;
                    }
                }
            }
        }
        return list;
    }
}
