package binary_tree;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author：THIEM
 * @create:2021/11/6-11:52
 * 用队列实现,用deque可以实现栈，关键是看你，想唉尾部实现栈，还是在首部实现栈！！！
 */
public class leetCode103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        Deque<TreeNode> deque =new LinkedList<>();
        int flag=1;
        if(root==null) return ans;
        deque.push(root);
        while(!deque.isEmpty()){
            int size=deque.size();
            List<Integer> item=new LinkedList<>();
            for(int i=0;i<size;i++){
                TreeNode cur = deque.poll();
                item.add(cur.val);
                if(cur.left!=null){
                    deque.offer(cur.left);
                }
                if(cur.right!=null){
                    deque.offer(cur.right);
                }
            }
            if(flag==1){
                ans.add(item);
            }
            else {
                Collections.reverse(item);
                ans.add(item);
            }
            flag*=-1;
        }

        return ans;
    }
}
