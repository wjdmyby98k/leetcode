package binary_tree;

/**
 * @author：THIEM
 * @create:2021/9/16-10:23
 */
public class leetCode701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        TreeNode cur=root;
        if(root==null) return node;  //题目特殊情况空树
        while(true){
            if(cur.val<val){  //放右边
                if(cur.right==null){
                    cur.right=node;
                    break;
                }
                cur=cur.right;
            }else if(cur.val>val){  //放左边
                if(cur.left==null){
                    cur.left=node;
                    break;
                }
                cur=cur.left;
            }
        }

        return root;
    }
}
