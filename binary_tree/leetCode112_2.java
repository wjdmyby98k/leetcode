package binary_tree;

import java.util.Stack;

/**
 * @author：THIEM
 * @create:2021/9/6-22:39
 */
public class leetCode112_2 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        Stack<TreeNode> stack1=new Stack<>();    //记录结点
        Stack<Integer> stack2=new Stack<>();     //记录结点对应的sum
        stack1.push(root);
        stack2.push(root.val);
        while(!stack1.isEmpty()){
            int size=stack1.size();
            for(int i=0;i<size;i++){
                TreeNode node = stack1.pop();
                int sum=stack2.pop();
                if(node.left==null && node.right==null){  //遇到叶子结点就判断sum
                    if(sum==targetSum) return true;
                }
                if(node.left!=null){   //这里先放左，先放右都无所谓
                    stack1.push(node.left);
                    stack2.push(sum+node.left.val);
                }
                if(node.right!=null){
                    stack1.push(node.right);
                    stack2.push(sum+node.right.val);
                }
            }
        }
        return false;
    }
}
