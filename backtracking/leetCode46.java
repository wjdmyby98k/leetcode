package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author：THIEM
 * @create:2021/9/24-10:59
 * 全排列1,排列问题不好用index，因为是要从剩下的找
 * 这算是比较简单的回溯，注意used数组的作用
 */
public class leetCode46 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used=new boolean[nums.length];
        backtracking(nums,used);
        return result;
    }
    public void backtracking(int[] nums,boolean[] used){
        if(path.size()==nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            used[i]=true;
            path.add(nums[i]);
            backtracking(nums,used);
            path.removeLast();
            used[i]=false;
        }
    }
}





