package greedy_algorithm;

/**
 * @author：THIEM
 * @create:2021/9/22-10:46
 * 暴力解法，第一层循环寻找起始位置，第二层循环遍历当前起始位置到结尾的最大值
 * 因为是要寻找连续子序列嘛，所以肯定在某个循环里面可以找到
 */
public class leetCode53 {
    public int maxSubArray(int[] nums) {
        int result=Integer.MIN_VALUE;
        int count;
        for(int i=0;i<nums.length;i++){
            count=0;
            for(int j=i;j<nums.length;j++){
                count+=nums[j];
                result=result>count?result:count;
            }
        }
        return result;
    }
}
