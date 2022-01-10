package binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author：THIEM
 * @create:2021/9/6-22:53
 */
public class leetCode113 {
    List<List<Integer>> result=new ArrayList<>();
    LinkedList<Integer> path =new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null) return result;
        path.add(root.val);  //这一部分其实可以放到回溯里面，当然，如果放在里面，回溯那一步就不要重复添加了
        backtracking(root,targetSum);
        return result;
    }
    public void backtracking(TreeNode root,int count){
        if(root.left==null && root.right==null){
            if(count==0){
                result.add(new ArrayList<>(path));
                return;
            }
        }
        if(root.left!=null){
            path.add(root.left.val);
            backtracking(root.left,count-root.left.val);
            path.removeLast();
        }
        if(root.right!=null){
            path.add(root.right.val);
            backtracking(root.right,count-root.right.val);
            path.removeLast();
        }
    }
}
