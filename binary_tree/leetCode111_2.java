package binary_tree;

/**
 * @author：THIEM
 * @create:2021/9/3-14:12
 */
public class leetCode111_2 {
    public int minDepth(TreeNode root) {
        return getMinDepth(root);
    }
    public int getMinDepth(TreeNode node){

        if(node==null) return 0;
        int leftDepth=getMinDepth(node.left);
        int rightDepth=getMinDepth(node.right);
        if(node.left!=null && node.right==null){    //左子树不为空
            return 1+leftDepth;
        }
        if(node.left==null && node.right!=null){     //右子树不为空
            return 1+rightDepth;
        }
        return 1+Math.min(leftDepth,rightDepth);

    }
}
