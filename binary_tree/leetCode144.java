package binary_tree;
import java.util.ArrayList;

/**
 * @author：THIEM
 * @create:2021/8/17-13:02
 * 这一题是假设结点内部的逻辑已知的，不需要单独去写结点的逻辑
 */
//Definition for a binary tree node.
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
  }
public class leetCode144 {
    public ArrayList<Integer> preOrderReverse(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        preOrder(root, result);
        return result;
    }

    void preOrder(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);           // 注意这一句
        preOrder(root.left, result);
        preOrder(root.right, result);
    }
}
