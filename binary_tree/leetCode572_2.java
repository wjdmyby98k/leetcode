package binary_tree;

/**
 * @author：THIEM
 * @create:2021/8/28-14:43
 * 用递归写,自己写的！！！！
 */
public class leetCode572_2 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null) return false;
        if(isSame(root,subRoot)){
            return true;
        }
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }
    public Boolean isSame(TreeNode p,TreeNode q){
        if(p==null && q==null){
            return true;
        }else if(p!=null && q==null){
            return false;
        }else if(p==null && q!=null){
            return false;
        }else if(p.val!=q.val){
            return false;
        }
        return isSame(p.left,q.left) && isSame(p.right,q.right);
    }
}
