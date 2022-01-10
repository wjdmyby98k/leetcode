package daily_one_problem;

import java.util.Arrays;

/**
 * @author：THIEM
 * @create:2021/12/21-15:30
 * 下一个排列   4 , 5, 2 ,6 ,3 ,1
 * 自己写的太丑了，尤其是反转数组，可以写的更好一点，但是逻辑清晰
 */
public class leetCode31 {
    public void nextPermutation(int[] nums) {
        if(nums.length==1) return;
        int a=-1;  // 起始值-1，没变就是代表是最大序列，直接返回最小的
        int b=-1;
        for(int i=nums.length-1;i>=1;i--){
            if(nums[i-1]>=nums[i]){
                continue;
            }else {
                a=i-1;
                break;
            }
        }
        if(a==-1){
            Arrays.sort(nums);
            return;
        }
        for(int j=nums.length-1;j>=a+1;j--){
            if(nums[j]>nums[a]){
                b=j;
                break;
            }
        }
        swap(nums,a,b);
//        System.out.println("a="+a+" b="+b);
        // 反转
        for(int i=0;i<(nums.length-1-a)/2;i++){
            swap(nums,a+1+i,nums.length-1-i);
        }

    }
    public void swap(int[] nums,int a, int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}
