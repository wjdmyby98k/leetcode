package binary_tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author：THIEM
 * @create:2021/8/28-14:09
 * BFS写
 */
public class leetCode572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Boolean flag=false;
        Deque<TreeNode> deque=new LinkedList<>();
        deque.push(root);
        while(deque.size()!=0){
            TreeNode node=deque.poll();
            if(node.val==subRoot.val){
                flag=isSameTree(node,subRoot);
                if(flag){
                    break;
                }
            }
            if(node.left!=null) deque.push(node.left);
            if(node.right!=null) deque.push(node.right);
        }
        return flag;
    }
    public Boolean isSameTree(TreeNode p,TreeNode q){
        if(p==null && q==null){
            return true;
        }else if(p!=null && q==null){
            return false;
        }else if(p==null && q!=null){
            return false;
        } else if(p.val!=q.val){
            return false;
        }
        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
}
