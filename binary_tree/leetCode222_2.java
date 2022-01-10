package binary_tree;

/**
 * @author：THIEM
 * @create:2021/9/3-15:41
 * 普通二叉树统一写法简化版
 */
public class leetCode222_2 {
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        return countNodes(root.left)+countNodes(root.right)+1;
    }
}
