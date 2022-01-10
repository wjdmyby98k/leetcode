package array;

import java.util.Arrays;

/**
 * @author：THIEM
 * @creat:2021/7/4-18:50
 * 给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 双指针，起始左边的指针为0，右边指针也为0，右边指针向右依次加1，每次加1以后判断当前右指针指向的元素是否等于val，如果不是的话
 * 就令nums[left]=nums[right],同时左右指针都加1，如果是的话，就跳过，左指针不变，右指针加一。循环到最后一步结束，左指针指向的
 * 就是剩余的长度
 */
public class LeetCode27 {
    public static void main(String[] args) {
        int []nums=new int[]{3,2,2,2};
        int val=3;
        int left=removeElement(nums,3);
        System.out.println(left);

    }
    public static int removeElement(int[] nums,int val){
        int left=0;
        for(int right=0;right<nums.length;right++){
            if(nums[right]!=val){
                nums[left]=nums[right];
                left++;//因为这里是只需要看left以前的元素，而这里又加1了，所以实际长度就是left

            }
        }
        System.out.println(Arrays.toString(nums));
        return left;
    }

}
