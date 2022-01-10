package binary_tree;

/**
 * @author：THIEM
 * @create:2021/9/1-16:00
 * 回溯好像也能做
 */
public class leetCode104_3 {
    int result=0;
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        backtracking(root,1);
        return result;
    }
    public void backtracking(TreeNode root,int depth){
//        if (root.left == null && root.right == null) return ;

        if(root==null) return;  //这一步可以省略，因为root不可能是null，上一步如果要加的话，要加到下面这句话下面！
        result=depth>result?depth:result;
        if(root.left!=null){
            depth++;
            backtracking(root.left,depth);
            depth--;
        }
        if(root.right!=null){
            depth++;
            backtracking(root.right,depth);
            depth--;
        }
        return;
    }
}
