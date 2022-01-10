package binary_tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author：THIEM
 * @create:2021/9/3-16:14
 * 层序遍历BFS,递归不会就用BFS，简单好理解
 */
public class leetCode222_4 {
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int result=0;
        Deque<TreeNode>deque=new LinkedList<>();
        deque.offer(root);
        while(!deque.isEmpty()){
            int size=deque.size();
            for(int i=0;i<size;i++){
                TreeNode node=deque.poll();
                if(node.left!=null) deque.offer(node.left);
                if(node.right!=null) deque.offer(node.right);
                result++;
            }
        }
        return result;
    }
}
