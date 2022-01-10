package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author：THIEM
 * @create:2021/8/31-2:00
 * 组合总和2,这题要去重，不是简单的i+1就可以的！
 * 去重用到used数组，全是bool类型的，具体可以看carl讲解
 */
public class leetCode40 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path =new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        boolean [] used =new boolean[candidates.length];
        backtracking(candidates,target,0,0,used);
        return result;
    }
    public void backtracking(int[] candidates,int target,int sum,int startIndex,boolean[] used){
        if(sum==target){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=startIndex;i<candidates.length;i++){
            //这里需要加一个额外条件，只有数组有序，才能保证，后面的都一定大，才不用搜了
            if(sum+candidates[i]>target) break;
            //candidates前一个与当前相等,表明同一层或者同一树枝有重复的
            //used[i-1]=true表明同一树枝，表明可以重读选取，否则表示同一层，不能再继续选
            if(i>=1 && candidates[i]==candidates[i-1] && used[i-1]==false) continue;
            sum+=candidates[i];
            used[i]=true;
            path.add(candidates[i]);
            backtracking(candidates,target,sum,i+1,used);
            used[i]=false;
            sum-=candidates[i];
            path.removeLast();
        }
    }
}
