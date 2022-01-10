package binary_tree;

/**
 * @author：THIEM
 * @create:2021/9/25-16:44
 * 注意遍历顺序是右 中 左
 */
public class leetCode538 {
    int pre=0;  // 记录前一堆结点的值
    public TreeNode convertBST(TreeNode root) {
        traversal(root);
        return root;
    }
    public void traversal(TreeNode root){
        if(root==null) return;
        traversal(root.right);
        root.val+=pre;
        pre=root.val;
        traversal(root.left);
    }
}
