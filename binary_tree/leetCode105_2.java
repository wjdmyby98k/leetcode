package binary_tree;

/**
 * @author：THIEM
 * @create:2021/9/12-13:07 优化版本，只传同一个数组和下标
 */
public class leetCode105_2 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree2(preorder, 0, preorder.length,
                inorder, 0, inorder.length);
    }

    public TreeNode buildTree2(int[] preorder, int preLeft, int preRight,
                               int[] inorder, int inLeft, int inRight) {
        if (inRight - inLeft < 1) {
            return null;
        }
        if (inRight - inLeft == 1) {
            return new TreeNode(preorder[preLeft]);
        }
        int val = preorder[preLeft];
        TreeNode root = new TreeNode(val);
        int index = inLeft;
        for (int i = inLeft; i < inRight; i++) {
            if (inorder[i] == val) {
                index = i;
                break;
            }
        }
        root.left = buildTree2(preorder, preLeft + 1, index - inLeft + preLeft + 1,
                inorder, inLeft, index);
        root.right = buildTree2(preorder, index - inLeft + preLeft + 1, preRight,
                inorder, index + 1, inRight);
        return root;

    }
}
