package binary_tree;

/**
 * @author：THIEM
 * @create:2021/9/15-21:43
 * 这题属于困难了
 * p 和 q 均存在于给定的二叉树中,说明一定是有解的
 * 如果没有的话，下面的方法也能过，因为没有也会返回null
 */
public class leetCode236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //这样理解，这个递归函数的作用就是先找到p和q的位置，再往上层层返回
        if(root==null) return null;
        if(root==p || root ==q) return root;
        TreeNode leftNode=lowestCommonAncestor(root.left,p,q);
        TreeNode rightNode= lowestCommonAncestor(root.right,p,q);
        if(leftNode==null) {
            return rightNode;
        }
        if(rightNode==null) {
            return leftNode;
        }
        if(rightNode!=null && leftNode!=null) {
            //这里之所以会报恒为true，是因为到达的时候，肯定是true
            // 实际上末尾的 return null是象征性的
            //或者把最后一个if直接删除，然后return null改为return root
            return root;
        }
        return null;
    }
}
