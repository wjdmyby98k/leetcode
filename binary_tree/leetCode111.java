package binary_tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author：THIEM
 * @create:2021/8/20-15:56
 * 最小深度,BFS
 */
public class leetCode111 {
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        int depth=0;
        Deque<TreeNode> deque=new LinkedList<>();
        deque.offer(root);
        while(!deque.isEmpty()){
            int size= deque.size();

            for(int i=0;i<size;i++){
                TreeNode node = deque.poll();
                if(node.left!=null) deque.offer(node.left);
                if(node.right!=null) deque.offer(node.right);
                if(node.left==null & node.right==null){
                    return depth+1;
                }
            }
            depth++;
        }
        return depth;
    }
}
