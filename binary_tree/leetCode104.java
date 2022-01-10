package binary_tree;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author：THIEM
 * @create:2021/8/20-15:20
 * 迭代法最大深度,后面用递归再写一遍
 */
public class leetCode104 {
    @Test
    public void Test(){
        System.out.println(1);
    }
    public int maxDepth(TreeNode root) {
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
            }
            depth++;
        }
        return depth;
    }
}
