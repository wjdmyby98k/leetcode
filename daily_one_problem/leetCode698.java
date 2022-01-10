package daily_one_problem;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author：THIEM
 * @create:2021/10/20-1:16 nums=[1,1,2,2,2,5,5,6]
 */
public class leetCode698 {
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> ans=new LinkedList<>();
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % k != 0) return false;// 除不尽肯定不能分割
        Arrays.sort(nums);
        int meanSum=sum/k; // 每份的和
        if (nums[nums.length - 1] > sum / k) return false; // 最大值太大，也不能分割，比如2,8分成两份
        int[] used=new int[nums.length]; //用来标记这个数有没有用过，初始化全是0
        backtracking(nums,used,k,0,0,meanSum); // n代表已经分了几份
        return false;
    }

    public boolean backtracking(int[] nums, int[] used, int k, int n,int curSum,int meanSum) {
        if(n==k-1) return true; // 最后一份也不用分了
        for(int i=0;i<used.length;i++){
            if (used[i]==0){
                path.add(nums[i]);
                used[i]=1;
                curSum+=nums[i];
                if(curSum==meanSum){
                    if(backtracking(nums,used,k,n+1,0,meanSum)){
                        return true;
                    }
                }else {
                    if(backtracking(nums,used,k,n,curSum,meanSum)){
                        return true;
                    }
                }
                path.removeLast();
                used[i]=0;
            }
        }
        return false;
    }
}
