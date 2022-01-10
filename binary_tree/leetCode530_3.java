package binary_tree;

import java.util.Stack;

/**
 * @author：THIEM
 * @create:2021/9/14-17:50
 * 用中序遍历的迭代写
 */
public class leetCode530_3 {
    public int getMinimumDifference(TreeNode root) {
        int result=Integer.MAX_VALUE;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode pre=null;
        TreeNode cur=root;
        while(cur!=null || !stack.isEmpty()){
            if(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }else {
                cur =stack.pop();
                if(pre!=null){
                    result= Math.min(result,cur.val- pre.val);
                }
                pre=cur;
                cur=cur.right;
            }
        }
        return result;
    }
}
