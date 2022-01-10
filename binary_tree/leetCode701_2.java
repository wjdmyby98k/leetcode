package binary_tree;

/**
 * @author：THIEM
 * @create:2021/9/16-15:01
 * 用递归写，要求是返回根节点
 */
public class leetCode701_2 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null) {
            TreeNode node =new TreeNode(val);
            return node;
        }
        if(root.val>val){  //在左边
            //不用考虑为null，因为root一定存在，left肯定已经操作的
            root.left=insertIntoBST(root.left,val);
        }
        else if(root.val<val){  //在右边
            root.right=insertIntoBST(root.right,val);
        }
        return root;

    }

}
