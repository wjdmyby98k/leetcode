package binary_tree;

/**
 * @author：THIEM
 * @create:2021/9/3-15:38
 * 普通二叉树统一写法
 */
public class leetCode222 {
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int leftCount=countNodes(root.left);
        int rightCount=countNodes(root.right);
        int treeCount=leftCount+rightCount+1;
        return treeCount;
    }
}
