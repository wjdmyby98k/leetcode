package binary_tree;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author：THIEM
 * @create:2021/8/19-0:38
 * 二叉树的层序遍历
 * 这里是用队列实现！！！不是栈！
 */
public class leetCode102 {
    //迭代法
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        Deque<TreeNode> deque=new LinkedList<>();
        if(root==null) return result;
        deque.offer(root);
        while(deque.size()>0){
            List<Integer> item =new ArrayList<>();
            //注意这里不能使用deque.size(),因为每次可能要放结点进去，会变化，要用固定大小
            int size=deque.size();
            for(int i=0;i<size;i++){
                TreeNode node=deque.poll();
                item.add(node.val);
                if(node.left!=null) deque.offer(node.left);  //这里用offer其实不太规范！offer是加在链表末尾
                if(node.right!=null) deque.offer(node.right);
            }
            result.add(item);
        }
        return result;
    }

}
