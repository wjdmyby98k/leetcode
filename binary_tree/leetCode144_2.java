package binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author：THIEM
 * @create:2021/8/17-18:23
 * 前后中序，迭代写法
 */
public class leetCode144_2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null){
                stack.push(node.right);
            }
            if (node.left != null){
                stack.push(node.left);
            }
        }
        return result;
    }
}
