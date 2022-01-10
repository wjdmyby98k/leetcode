package greedy_algorithm;

/**
 * @author：THIEM
 * @create:2021/9/22-10:53
 * 用贪心做
 * 用count记录累加的和，如果为负，就置0，因为负数是拉后腿的！！！即使数组全部为负，这个思路也是可以的！
 * 同时也要判断result和count并且更新
 */
public class leetCode53_2 {
    public int maxSubArray(int[] nums) {
        int result=Integer.MIN_VALUE;
        int count=0;
        for(int i =0;i<nums.length;i++){
            count+=nums[i];
            if(count>result){   //更新result
                result=count;
            }
            if(count<0){        //遇到负数和就置0，负数拖后腿
                count=0;
            }
        }
        return result;
    }
}
