package binary_tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author：THIEM
 * @create:2021/8/28-11:31
 * 层序遍历做，每次取两个结点比较
 */
public class leetCode101_2 {
    public boolean isSymmetric(TreeNode root) {
        Deque<TreeNode> deque=new LinkedList<>();
        if(root==null) return true;
        deque.push(root.left);
        deque.push(root.right);
        while(!deque.isEmpty()){
            TreeNode node1=deque.poll();
            TreeNode node2=deque.poll();
            if(node1==null && node2!=null){
                return false;
            }else if(node1!=null && node2==null){
                return false;
            }else if(node1==null && node2==null){
                continue;
            }else if(node1.val!=node2.val){
                return false;
            }else {
                deque.push(node1.left);
                deque.push(node2.right);
                deque.push(node1.right);
                deque.push(node2.left);
            }
        }
        return true;
    }
}
