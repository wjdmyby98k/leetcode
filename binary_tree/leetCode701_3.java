package binary_tree;

/**
 * @author：THIEM
 * @create:2021/9/16-15:13
 * 不带返回值的递归
 *
 */
public class leetCode701_3 {
    TreeNode parent;
    TreeNode cur;
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null) return new TreeNode(val);
        traversal(root,val);
        return root;
    }
    public void traversal(TreeNode cur,int val){
        if(cur==null){
            TreeNode node = new TreeNode(val);
            if(parent.val>val){
                    parent.left=node;
            }else {
                    parent.right=node;
            }
            return;
        }
        parent=cur;
        if(cur.val>val){
            traversal(cur.left,val);
        }else if(cur.val<val){
            traversal(cur.right,val);
        }

    }
}
