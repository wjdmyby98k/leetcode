package binary_tree;

/**
 * @author：THIEM
 * @create:2021/9/3-16:28 求深度用前序遍历，求高度用后序遍历
 * 因为求深度可以从上到下去查 所以需要前序遍历（中左右），而高度只能从下到上去查，所以只能后序遍历（左右中）
 * <p>
 * 有的同学一定疑惑，为什么104.二叉树的最大深度中求的是二叉树的最大深度，也用的是后序遍历。
 * <p>
 * 那是因为代码的逻辑其实是求的根节点的高度，而根节点的高度就是这颗树的最大深度，所以才可以使用后序遍历。
 */
public class leetCode110 {
    public boolean isBalanced(TreeNode root) {
        boolean flag = getDepth(root) != -1;
        return flag;
    }

    public int getDepth(TreeNode root) {  // 返回以该节点为根节点的二叉树的高度，如果不是二叉搜索树了则返回-1
        if (root == null) return 0;
        int leftDepth = getDepth(root.left);
        if (leftDepth == -1) return -1;  // 说明左子树已经不是二叉平衡树
        int rightDepth = getDepth(root.right);
        if (rightDepth == -1) return -1;  // 说明右子树已经不是二叉平衡树
        return Math.abs(leftDepth - rightDepth) > 1 ? -1 : 1 + Math.max(leftDepth, rightDepth);
    }
}
