package binary_tree;

import java.util.Arrays;

/**
 * @author：THIEM
 * @create:2021/9/12-12:30 给前序和中序，求树
 * tips：复制数组用Arrays.copyOfRange
 */
public class leetCode105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree2(preorder, inorder);
    }

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }

        int val = preorder[0];
        TreeNode root = new TreeNode(val);

        if (preorder.length == 1) {
            return root;
        }
        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == val) {
                index = i;
                break;
            }
        }
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, index);
        int[] rightInorder = Arrays.copyOfRange(inorder, index + 1, inorder.length);
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, index + 1);
        int[] rightPreorder = Arrays.copyOfRange(preorder, index + 1, preorder.length);
        root.left = buildTree(leftPreorder, leftInorder);
        root.right = buildTree2(rightPreorder, rightInorder);
        return root;
    }
}
