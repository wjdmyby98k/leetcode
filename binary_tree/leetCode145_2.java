package binary_tree;

import java.util.*;

/**
 * @author：THIEM
 * @create:2021/8/28-1:03
 * 后序遍历迭代法，中左右-->中右左-->左右中
 */
public class leetCode145_2 {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result=new ArrayList<>();
        if(root==null) return result;
        Deque<TreeNode> deque=new LinkedList<>();
        deque.push(root);
        while(!deque.isEmpty()){
            TreeNode node=deque.poll();
            result.add(node.val);
            if(node.left!=null) deque.push(node.left);
            if(node.right!=null) deque.push(node.right);
        }
        Collections.reverse(result);
        return result;
    }
}
