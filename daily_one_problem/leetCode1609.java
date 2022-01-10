package daily_one_problem;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author：THIEM
 * @create:2021/12/27-19:06 广度优先遍历，层序遍历
 * 偶数层，奇数递增
 * 奇数层，偶数递减
 */
public class leetCode1609 {
    public boolean isEvenOddTree(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        int level = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            TreeNode pre = deque.peek();
            int cur_val = 0;
            int pre_val = 0;
            for (int i = 0; i < size; i++) {
                TreeNode cur = deque.poll();
                if (i == 0) {
                    cur_val = cur.val;
                    pre_val = cur_val;
                    if (level % 2 == 0 && cur_val % 2 == 0) return false;
                    if (level % 2 == 1 && cur_val % 2 == 1) return false;
                } else {
                    cur_val = cur.val;
                    if (level % 2 == 0) {
                        if (cur_val % 2 == 0 || cur_val <= pre_val) return false;

                    } else {
                        if (cur_val % 2 == 1 || cur_val >= pre_val) return false;
                    }
                    pre_val = cur_val;
                }

                if (cur.left != null) deque.add(cur.left);
                if (cur.right != null) deque.add(cur.right);
            }
            level++;
            System.out.println(level);
        }
        return true;
    }
}
