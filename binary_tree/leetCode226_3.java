package binary_tree;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author：THIEM
 * @create:2021/8/28-0:28
 * 迭代法，前序遍历
 */
public class leetCode226_3 {
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        Deque<TreeNode> deque=new LinkedList<>();
        deque.push(root);
        while(!deque.isEmpty()){
            TreeNode node = deque.poll();
            swap(node);
            if(node.right!=null) deque.push(node.right);  //其实这里先右先左都没关系，这题用前序做就是小题大做！
            if(node.left!=null) deque.push(node.left);
        }
        return root;
    }
    public void swap(TreeNode root){
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
    }
}


