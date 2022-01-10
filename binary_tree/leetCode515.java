package binary_tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author：THIEM
 * @create:2021/8/19-22:43
 */
public class leetCode515 {
    public List<Integer> largestValues(TreeNode root) {
       List<Integer> result=new ArrayList<>();
        if(root==null) return result;
        Deque<TreeNode> deque=new LinkedList<>();
        deque.offer(root);
        while(!deque.isEmpty()){
            int size = deque.size();
            TreeNode firstNode=deque.peekFirst();
            int max=firstNode.val;
            for(int i=0;i<size;i++){
                TreeNode node = deque.poll();
                if(node.val>max){ //寻找最大值
                    max=node.val;
                }
                if(node.left!=null) deque.offer(node.left);
                if(node.right!=null) deque.offer(node.right);
            }
            result.add(max);//每一层遍历完了，再加进去
        }
        return result;
    }
}
