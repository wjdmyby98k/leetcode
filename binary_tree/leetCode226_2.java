package binary_tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author：THIEM
 * @create:2021/8/28-0:07
 * BFS，层序遍历写
 */
public class leetCode226_2 {
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        Deque<TreeNode> deque=new LinkedList<>();
        deque.push(root);
        while(!deque.isEmpty()){
            int size=deque.size();
            while(size-->0){
                TreeNode node=deque.poll();
                swap(node);
                if(node.left!=null) deque.push(node.left);
                if(node.right!=null) deque.push(node.right);
            }

        }
        return root;
    }
    public void swap(TreeNode root){
        TreeNode temp=root.left;//这里貌似不用考虑null的问题
        root.left=root.right;
        root.right=temp;
    }
}
