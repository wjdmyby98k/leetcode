package binary_tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author：THIEM
 * @create:2021/9/6-19:49
 * 用迭代写,即层序遍历
 */
public class leetCode404_2 {
    public int sumOfLeftLeaves(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        int sum = 0;
        if (root == null) {
            return 0;
        }
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                if (node.left != null) deque.add(node.left);
                if (node.right != null) deque.add(node.right);
                if (node.left != null && node.left.left == null && node.left.right == null) {
                    sum += node.left.val;
                }
            }
        }
        return sum;
    }
}
