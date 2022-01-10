package binary_tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author：THIEM
 * @create:2021/8/28-0:41
 */
public class leetCode94_2 {
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result=new ArrayList<>();
        if(root==null) return result;
        Deque<TreeNode> deque=new LinkedList<>();
        TreeNode cur =root;
        while(cur!=null || deque.size()!=0){
            if(cur!=null){  //访问最底层
                deque.push(cur);
                cur=cur.left;
            }else {
                cur=deque.poll();
                result.add(cur.val);
                cur=cur.right;

            }
        }
        return result;
    }
}
