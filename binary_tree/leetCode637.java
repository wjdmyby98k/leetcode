package binary_tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author：THIEM
 * @create:2021/8/19-21:44
 */
public class leetCode637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) return result;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            double sum = 0; //注意这里一定要是double，不然int再转为double会精度损失
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                sum += node.val;
                if (node.left != null) deque.offer(node.left);
                if (node.right != null) deque.offer(node.right);
            }
            result.add(sum / size);
        }
        return result;
    }
}
