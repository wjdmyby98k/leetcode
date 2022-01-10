package binary_tree;

/**
 * @author：THIEM
 * @create:2021/8/28-2:19
 * 对称二叉树,递归写
 */
public class leetCode101 {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return compare(root.left,root.right);
    }
    public boolean compare(TreeNode left, TreeNode right){
        if(left==null && right!=null){
            return false;
        }else if(right==null && left!=null){
            return false;
        }else if(left==null && right==null){
            return true;
        }else if(left.val!=right.val){
            return false;
        }
        boolean outside=compare(left.left,right.right);
        boolean inside=compare(left.right,right.left);
        return outside&&inside;
    }
}
