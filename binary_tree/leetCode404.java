package binary_tree;

/**
 * @author：THIEM
 * @create:2021/9/6-17:49
 * 左叶子之和
 * 如果左节点不为空，且左节点没有左右孩子，那么这个节点就是左叶子
 */
public class leetCode404 {
    public int sumOfLeftLeaves(TreeNode root) {
        return getLeftLeavesSum(root);
    }
    public int getLeftLeavesSum(TreeNode node){
        if(node==null) return 0;
        int leftSum=getLeftLeavesSum(node.left);
        int rightSum=getLeftLeavesSum(node.right);
        int ans=0;
        if(node.left!=null && node.left.left==null && node.left.right==null){
            ans=node.left.val;
        }
        return ans+leftSum+rightSum;   //感觉这里是不太好理解的，可以联系类比一下深度的递归代码
    }
}
