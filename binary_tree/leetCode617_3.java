package binary_tree;

/**
 * @author：THIEM
 * @create:2021/9/13-16:47
 * 递归简洁写法，面试争取这样写，自己的第一版写的太烂了
 */
public class leetCode617_3 {
    // 递归
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        TreeNode newRoot = new TreeNode(root1.val + root2.val);
        newRoot.left = mergeTrees(root1.left,root2.left);
        newRoot.right = mergeTrees(root1.right,root2.right);
        return newRoot;
    }
}
