package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author：THIEM
 * @create:2021/9/22-15:12
 * 这题不能排序！！！
 * 同一层去重，然后要是递增子序列，意味着是连续的！！！
 * 去重是同一层数字一样的要去掉，所以可以用hash表代表同样的值，仅仅有布尔used数组感觉不方便
 */
public class leetCode491 {
    List<List<Integer>> result = new ArrayList<>();// 存放符合条件结果的集合
    LinkedList<Integer> path = new LinkedList<>();// 用来存放符合条件结果

    public List<List<Integer>> findSubsequences(int[] nums) {
        if(nums.length<=1){
            return result;
        }
        backtracking(nums,0);
        return result;
    }
    public void backtracking(int[] nums,int index){
        int[] used=new int[201];  // 用来去重的,每一层都不一样
        if(path.size()>=2){
            result.add(new ArrayList<>(path));
        }
        for(int i=index;i<nums.length;i++){
            if(!path.isEmpty() && nums[i]<path.get(path.size()-1) || used[nums[i]+100]==1){
                //注意这里是要小于path里的最后一个
                continue;
            }
            used[nums[i]+100]=1; //代表nums[i]用过
            path.add(nums[i]);
            backtracking(nums,i+1);
            path.removeLast();
        }
    }
}
