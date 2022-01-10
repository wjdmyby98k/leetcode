package greedy_algorithm;



import java.util.Arrays;
import java.util.Comparator;

/**
 * @author：THIEM
 * @create:2021/10/5-3:08
 * 贪心思想
 * 第一步：将数组按照绝对值大小从大到小排序，注意要按照绝对值的大小
 * 第二步：从前向后遍历，遇到负数将其变为正数，同时K--
 * 第三步：如果K还大于0，那么反复转变数值最小的元素，将K用完
 * 第四步：求和
 */
public class leetCode1005 {
    public int largestSumAfterKNegations(int[] nums, int K) {
        // 自定义比较器，根据绝对值排序
        Comparator<Integer> comparator=(o1,o2)->Integer.compare(Math.abs(o2),Math.abs(o1));
        Integer[] sorted=new Integer[nums.length];
        for(int i=0;i<nums.length;i++){
            sorted[i]=nums[i];
        }
        Arrays.sort(sorted,comparator);
        for(int i=0;i<nums.length;i++){
            nums[i]=sorted[i];
        }
        System.out.println(Arrays.toString(nums));
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0 && K>0){
                nums[i]*=-1;
                K--;
            }
        }
        if(K%2==1){
            nums[nums.length-1]*=-1;
        }
        int sum=0;
        for (int i:nums){
            sum+=i;
        }
        return sum;
    }
}
