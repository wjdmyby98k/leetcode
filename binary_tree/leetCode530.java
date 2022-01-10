package binary_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author：THIEM
 * @create:2021/9/14-17:37
 * 也是先遍历，利用二叉搜索树中序递增的规律，建list再求差值
 */
public class leetCode530 {
    List<Integer> list=new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        traversal(root);
        int result=list.get(1)-list.get(0);
        for(int i=1;i<list.size()-1;i++){
            result= Math.min(list.get(i+1)-list.get(i),result);
        }
        return result;
    }
    public void traversal(TreeNode root){
        if(root==null) return;
        traversal(root.left);
        list.add(root.val);
        traversal(root.right);
        return;
    }
}
