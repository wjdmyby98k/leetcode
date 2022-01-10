package binary_tree;

import java.util.Stack;

/**
 * @author：THIEM
 * @create:2021/9/25-17:13
 * 用迭代写
 */
public class leetCode538_2 {
    public TreeNode convertBST(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        int pre=0; //记录前一堆结点的值
        if(root==null) return null;
        TreeNode cur=root;
        while(cur!=null || !stack.isEmpty()){
            if(cur!=null){
                stack.push(cur);
                cur=cur.right;
            }else {
                cur=stack.pop();
                cur.val+=pre;  //这里是加上前面一堆结点的值，想要加上相邻的，可以引入个temp记录cur.val
                pre=cur.val;
                cur=cur.left;
            }
        }
        return root;
    }
}
