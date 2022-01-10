package dynamic_programming;

/**
 * @author：THIEM
 * @create:2021/11/2-15:23 打家劫舍 III
 * 0代表不偷，1代表偷，每个结点用一个数组容量为2的数组记录
 */
public class leetCode337 {
    public int rob(TreeNode root) {
        int[] res=robAction(root);
        return Math.max(res[0],res[1]);
    }

    public int[] robAction(TreeNode root) {

        int[] res = new int[2];
        if (root == null) return res;
        int[] left = robAction(root.left);
        int[] right = robAction(root.right);
        res[1] = root.val + left[0] + right[0];
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return res;
    }
}
