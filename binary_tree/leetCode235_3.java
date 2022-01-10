package binary_tree;

/**
 * @author：THIEM
 * @create:2021/9/16-9:53
 * 迭代法
 */
public class leetCode235_3 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root!=null){
            if(root.val>p.val && root.val>q.val){  //在左边
                root=root.left;
            }
            else if(root.val<p.val && root.val<q.val){  //在右边
                root=root.right;
            }else {
                return root;
            }
        }
        return null;
    }
}


