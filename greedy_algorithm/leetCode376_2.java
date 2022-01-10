package greedy_algorithm;

import org.junit.Test;

/**
 * @author：THIEM
 * @create:2021/9/22-11:48
 * 思路：
 * 先快慢指针去除连续的重复元素
 * 这样就只剩下单调的序列，再统计连续的个数并删掉即可
 * 要求是o（n）
 */
public class leetCode376_2 {
    @Test
    public void Test(){
        int[] nums=new int[]{1,2,2,2,-1,-1,-5,6};
        int a=wiggleMaxLength(nums);
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]);
        }
    }
    public int wiggleMaxLength(int[] nums) {
        if(nums.length<=1) return nums.length;
        //先去掉重复元素
        int fast=1;
        int slow=0;  //去重以后slow就是有效的下标
        for(;fast<nums.length;fast++){
            if(nums[fast]!=nums[slow]){
                nums[++slow]=nums[fast];
            }
        }
        //统计单调需要删除的元素
        int count=0;
        for(int i=1;i<=slow-1;i++){
            if((nums[i]-nums[i-1]>0 && nums[i+1]-nums[i]>0) ||
                    (nums[i]-nums[i-1]<0 && nums[i+1]-nums[i]<0)){
                count++;
            }

        }
        // 总的元素   减去   需要删除的元素
        return slow+1-count;
    }
}
