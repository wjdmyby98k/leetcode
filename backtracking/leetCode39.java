package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author：THIEM
 * @create:2021/8/31-1:46
 * 组合总和1
 */
public class leetCode39 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path =new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates,target,0,0);
        return result;
    }
    public void backtracking(int[] candidates,int target,int sum,int startIndex){
        if(sum==target){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=startIndex;i<candidates.length;i++){
            //这里需要加一个额外条件，只有数组有序，才能保证，后面的都一定大，才不用搜了
            if(sum+candidates[i]>target) break;
            sum+=candidates[i];
            path.add(candidates[i]);
            backtracking(candidates,target,sum,i);
            sum-=candidates[i];
            path.removeLast();
        }
    }
}
