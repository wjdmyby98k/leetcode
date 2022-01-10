package binary_tree;

/**
 * @author：THIEM
 * @create:2021/9/14-16:57
 * 中序的另一种递归，学习一下思路
 */
public class leetCode98_2 {
    // 递归
    TreeNode max;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 左
        boolean left = isValidBST(root.left);
        if (!left) {
            return false;
        }
        // 中
        if (max != null && root.val <= max.val) {
            return false;
        }
        max = root;
        // 右
        boolean right = isValidBST(root.right);
        return right;
    }
}
