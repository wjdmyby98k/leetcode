package binary_tree;

/**
 * @author：THIEM
 * @create:2021/9/1-15:46
 * 确定单层递归的逻辑：先求它的左子树的深度，再求的右子树的深度，最后取左右深度最大的数值 再+1
 * （加1是因为算上当前中间节点）就是目前节点为根节点的树的深度。
 */
public class leetCode104_2 {
    public int maxDepth(TreeNode root) {
        return getDepth(root);

    }
    public int getDepth(TreeNode node){
        if(node==null) return 0;
        int leftDepth=getDepth(node.left);  //left
        int rightDepth=getDepth(node.right);  //right
        int depth= Math.max(leftDepth,rightDepth);  //middle,当前节点的深度=两边最大深度再+1
        return depth+1;
    }
}
