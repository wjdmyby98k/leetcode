package binary_tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author：THIEM
 * @create:2021/8/28-13:13
 * 用BFS写
 */
public class leetCode100_2 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Deque<TreeNode> deque1=new LinkedList<>();
        Deque<TreeNode> deque2=new LinkedList<>();
        if(p==null && q==null) return true;
        else if(p!=null && q==null) return false;
        else if(p==null && q!=null) return false;
        deque1.push(p);
        deque2.push(q);
        while(deque1.size()!=0 && deque2.size()!=0){
            TreeNode node1=deque1.poll();
            TreeNode node2=deque2.poll();
            if(node1==null && node2==null){
                continue;
            }else if(node1==null && node2!=null){
                return false;
            }else if(node1!=null && node2==null){
                return false;
            }else if(node1.val!=node2.val){
                return false;
            }
            deque1.push(node1.left);
            deque1.push(node1.right);
            deque2.push(node2.left);
            deque2.push(node2.right);
        }
        return true;
    }
}
