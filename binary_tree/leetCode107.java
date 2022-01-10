package binary_tree;

import java.util.*;

/**
 * @author：THIEM
 * @create:2021/8/19-15:40
 */
public class leetCode107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        Deque<TreeNode> deque=new LinkedList<>();
        if(root==null) return result;
        deque.offer(root);
        while(deque.size()>0){
            int size=deque.size();
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node=deque.poll();
                list.add(node.val);
                if(node.left!=null){
                    deque.offer(node.left);
                }
                if(node.right!=null){
                    deque.offer(node.right);
                }
            }
            result.add(list);
        }
        Collections.reverse(result);//集合的反转要用到collections工具类，当然手动反转也可以
        return result;
    }
}
