package binary_tree;

/**
 * @author：THIEM
 * @create:2021/9/14-17:44
 * 在递归中记录前一个节点的指针,免去建list
 */
public class leetCode530_2 {
    int result=Integer.MAX_VALUE;
    TreeNode pre;
    public void traversal(TreeNode root){
        if(root==null) return;
        traversal(root.left);   //left
        if(pre!=null){          //middle
            result= Math.min(result,root.val-pre.val);
        }
        pre=root;              //record pre
        traversal(root.right);  // right
        return;
    }
    public int getMinimumDifference(TreeNode root) {
        traversal(root);
        return result;
    }
}
