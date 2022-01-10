package backtracking;

import java.util.*;

/**
 * @author：THIEM
 * @create:2021/9/24-15:49
 * 直接全部排列，再去重，leet code可以可以过
 */
public class leetCode47_3 {
    List<List<Integer>> result= new ArrayList<>();
    LinkedList<Integer> path =new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        int[] used=new int[nums.length];
        backtracking(nums,used);
        HashSet<List<Integer>> hashSet=new HashSet<>();//list set转换有多种方式
        List<List<Integer>> ans= new ArrayList<>();
        hashSet.addAll(result);
        ans.addAll(hashSet);
        return ans;
    }
    public void backtracking(int[] nums,int[] used){
        if(path.size()==nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if (used[i] == 0) {

                used[i]=1;
                path.add(nums[i]);
                backtracking(nums,used);
                path.removeLast();
                used[i]=0;
            }
        }
    }
}
