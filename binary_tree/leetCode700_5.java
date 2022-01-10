package binary_tree;

/**
 * @author：THIEM
 * @create:2021/9/14-10:56
 * 回溯的标准写法
 */
public class leetCode700_5 {
    TreeNode ans=null;   //这里一定要是全局变量，不然backtracking访问不到
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null) return null;
        backtracking(root,val);
        return ans;
    }
    public void backtracking(TreeNode node,int val){
        if(node.val==val){
            ans=node;
            return ;
        }
        if(node.left!=null){
            backtracking(node.left,val);
        }
        if(node.right!=null){
            backtracking(node.right,val);
        }
        return;
    }
}
