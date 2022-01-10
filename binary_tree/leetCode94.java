package binary_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author：THIEM
 * @create:2021/8/17-17:28
 */
public class leetCode94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result=new ArrayList<>();
        inorder(root,result);
        return result;
    }
    public void inorder(TreeNode root,ArrayList<Integer> result){
        if(root==null) return;
        inorder(root.left,result);
        result.add(root.val);
        inorder(root.right,result);

    }
}
