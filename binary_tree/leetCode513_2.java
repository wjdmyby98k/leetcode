package binary_tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author：THIEM
 * @create:2021/9/6-21:04 递归不会就用迭代，迭代简单很多！
 * deque既可以是队列，也可以是栈，关键看你到底是用push还是offer，push就是加在头部，offer就是加在尾部，add等同于offer
 * 这题还不能用栈做，栈无法实现层序遍历！！！
 */
public class leetCode513_2 {
    public int findBottomLeftValue(TreeNode root) {
        int sum = 0;
        Deque<TreeNode> deque = new LinkedList<>();    //这里实际上是当做队列在用！！！
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            TreeNode leftNode = deque.peek();
            sum = leftNode.val;  //只记录每一层最开始的那个数，即最左边的数
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                if (node.left != null) deque.add(node.left);
                if (node.right != null) deque.add(node.right);
            }
        }
        return sum;
    }
}
