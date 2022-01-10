package binary_tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author：THIEM
 * @create:2021/9/13-19:10
 * 用深度优先写一些试试，增强DFS理解,用前序
 */
public class leetCode700_3 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> deque=new LinkedList<>();
        deque.offer(root);
        while(!deque.isEmpty()){
            TreeNode node = deque.poll();
            if(node.val==val){
                return node;
            }else {
                if(node.right!=null) deque.push(node.right);  //这里用前序，所以先右后左，其实顺序无所谓
                if(node.left!=null) deque.push(node.left);
            }
        }
        return null;
    }
}
