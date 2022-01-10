package backtracking;

import org.junit.Test;

import java.util.*;

/**
 * @author：THIEM
 * @create:2021/9/24-15:27
 * 前面都是用used数组去重，用set对每一层去重其实也可以
 * 或者直接干脆一点，把所有的结果算出来，再统一用个set去重，两种都试试，复杂度越来越大
 * 每一层set去重
 */
public class leetCode47_2 {
    @Test
    public void Test(){
        int[] nums= new int[]{1,1,2};
        permuteUnique(nums);
    }
    List<List<Integer>> result= new ArrayList<>();
    LinkedList<Integer> path =new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        int[] used=new int[nums.length];
        backtracking(nums,used);
        return result;
    }
    public void backtracking(int[] nums,int[] used){
        if(path.size()==nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                continue;
            }
            if(used[i]==0){
                // 这里set一定是要当前这个数字没用的时候再加进去
                // 否则出现相同的时候，后面会直接跳过
                set.add(nums[i]);
                used[i]=1;
                path.add(nums[i]);
                backtracking(nums,used);
                path.removeLast();
                used[i]=0;
            }
        }
    }
}
