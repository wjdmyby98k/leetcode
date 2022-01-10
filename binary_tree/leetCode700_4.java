package binary_tree;

import org.junit.Test;

/**
 * @author：THIEM
 * @create:2021/9/13-19:44
 * 用回溯写写试试，本质上也是DFS
 */
public class leetCode700_4 {
    @Test
    public void Test(){
        TreeNode node4=new TreeNode(4);
        TreeNode node2=new TreeNode(2);
        TreeNode node7=new TreeNode(4);
        TreeNode node1=new TreeNode(1);
        TreeNode node3=new TreeNode(3);
        node4.left=node2;
        node4.right=node7;
        node2.left=node1;
        node2.right=node3;
        TreeNode ans =searchBST(node4,2);
    }
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null) return null;
        TreeNode ans=new TreeNode(0);
        backtracking(root,val,ans);
        if(ans.val==0){
            return null;
        }
        return ans;

    }
    public void backtracking(TreeNode node,int val,TreeNode ans){
        if(node.val==val){
            ans=node;
            return ;
        }
        if(node.left!=null){
            backtracking(node.left,val,ans);
        }
        if(node.right!=null){
            backtracking(node.right,val,ans);
        }
        return;
    }
}
