package binary_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author：THIEM
 * @create:2021/8/17-17:23
 */
public class leetCode145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result=new ArrayList<>();
        postOrder(root,result);
        return result;
    }
    public void postOrder(TreeNode root,ArrayList<Integer> result){
        if(root==null) return;
        postOrder(root.left,result);
        postOrder(root.right,result);
        result.add(root.val);
    }
}
