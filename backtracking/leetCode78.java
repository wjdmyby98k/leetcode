package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author：THIEM
 * @create:2021/9/1-10:54
 */
public class leetCode78 {
//    @Test
//    public void Test() {
//        int[] nums = new int[]{1, 2, 3};
//        List list = new ArrayList();
//        Collections.addAll(list, nums);
//        int[] ans=(int[]) list.get(0);
//        for(int k:ans){
//            System.out.println(k);
//        }
//        System.out.println(list.size());
//        System.out.println(nums.length);
//    }
    List<List<Integer>> result =new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums,0);
        return result;
    }
    public void backtracking(int[] nums,int startIndex){
        result.add(new ArrayList<>(path)); //回溯一开始就把path加进去，path代表所有的节点，刚开始会加一个空，所以不用额外加空
        if(startIndex>=nums.length){  //这个其实可以不加，因为这个条件和循环终止的条件是一样的
            return;
        }
        for(int i=startIndex;i<nums.length;i++){
            path.add(nums[i]);
            backtracking(nums,i+1);
            path.removeLast();
        }
    }
}
