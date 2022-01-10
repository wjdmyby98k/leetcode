package binary_tree;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author：THIEM
 * @create:2021/9/15-21:04
 * 用迭代写，加深理解，中序的迭代，同样用一个pre记录
 * 中序遍历，刚开始，不需要讲结点放进去，但是层序遍历需要先放进去！！！
 */
public class leetCode501_3 {
    public int[] findMode(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        int count = 0;
        int maxCount = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {         //left
                stack.push(cur);
                cur = cur.left;
            }else {
                cur = stack.pop();        //middle
                if (pre == null || pre.val != cur.val) {
                    count = 1;
                } else {
                    count++;
                }
                if (count > maxCount) {
                    maxCount = count;
                    result.clear();
                    result.add(cur.val);
                } else if (count == maxCount) {
                    result.add(cur.val);
                }
                pre=cur;       // update pre!!!
                cur = cur.right;   // right
            }

        }
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }
}
