package binary_tree;

/**
 * @author：THIEM
 * @create:2021/8/28-12:59
 * 用递归写
 */
public class leetCode100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return same(p,q);
    }
    public boolean same(TreeNode left,TreeNode right){
        if(left==null && right!=null){
            return false;
        }else if(left!=null && right==null){
            return false;
        }else if(left==null && right==null){
            return true;
        }else if(left.val!=right.val) {
            return false;
        }
        boolean inside=same(left.left,right.left);
        boolean outside=same(left.right,right.right);
        return inside && outside;


    }
}
