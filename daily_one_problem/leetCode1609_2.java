package daily_one_problem;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author：THIEM
 * @create:2021/12/27-20:50 三叶的解法，初始化pre的值，满足默认的递增递减，省去第一个元素的判断！（对比解法1）
 * 因此简洁不少
 */
public class leetCode1609_2 {
    public boolean isEvenOddTree(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        Boolean flag = true;
        while (!deque.isEmpty()) {
            int size = deque.size();
            int prev = flag ? 0 : Integer.MAX_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                int cur = node.val;
                if (flag && (cur % 2 == 0 || cur <= prev)) return false;
                if (!flag && (cur % 2 == 1 || cur >= prev)) return false;
                prev = cur;
                if (node.left != null) deque.add(node.left);
                if (node.right != null) deque.add(node.right);
            }
            flag = !flag;
        }
        return true;
    }
}
