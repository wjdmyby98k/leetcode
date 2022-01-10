package binary_tree;

/**
 * @author：THIEM
 * @create:2021/9/6-22:03
 * 路径总和1，用回溯做,方法2用迭代，路径总和1的迭代还行，不算太难
 */
public class leetCode112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        boolean flag = backtracking(root, targetSum-root.val);
        return flag;
    }

    public boolean backtracking(TreeNode root, int count) {
        if (root.left == null && root.right == null) {
            if (count == 0) return true;
        }
        if (root.left != null) {
            if (backtracking(root.left, count - root.left.val)) {  //回溯
                return true;
            }
        }
        if (root.right != null) {
            if (backtracking(root.right, count - root.right.val)) {  //回溯
                return true;
            }
        }
        return false;
    }
}
