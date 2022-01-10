package binary_tree;

/**
 * @author：THIEM
 * @create:2021/9/16-9:44
 * 用递归写，递归写的时候，一定要注意在全局的思想上考虑
 *
 */
public class leetCode235_2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(root.val>p.val && root.val>q.val){
            TreeNode left=lowestCommonAncestor(root.left,p,q);
            if(left!=null){
                return left;
            }
        }
        if(root.val<p.val && root.val<q.val){
            TreeNode right=lowestCommonAncestor(root.right,p,q);
            if(right!=null){
                return right;
            }
        }
        return root;
    }
}
