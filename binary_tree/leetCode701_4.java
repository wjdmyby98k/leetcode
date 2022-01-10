package binary_tree;

/**
 * @author：THIEM
 * @create:2021/9/16-15:42
 * 另一种迭代方式
 */
public class leetCode701_4 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null) return new TreeNode(val);
        TreeNode cur=root;
        TreeNode parent=root;
        TreeNode node = new TreeNode(val);
        while(cur!=null){
            parent=cur;
            if(cur.val>val){
                cur=cur.left;
            }else {
                cur=cur.right;
            }

        }
       if(parent.val>val){
           parent.left=node;
       }else {
           parent.right=node;
       }
        return root;
    }
}
