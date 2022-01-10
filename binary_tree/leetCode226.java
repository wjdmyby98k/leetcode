package binary_tree;

/**
 * @author：THIEM
 * @create:2021/8/23-17:30
 * 反转二叉树
 */
public class leetCode226 {
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return root;
        swap(root);
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
    public void swap(TreeNode root){
        TreeNode temp=root.left;//这里貌似不用考虑null的问题
        root.left=root.right;
        root.right=temp;
    }
}