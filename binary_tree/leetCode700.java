package binary_tree;

/**
 * @author：THIEM
 * @create:2021/9/13-16:52
 * 二叉搜索树，左边的小，右边的大
 */
public class leetCode700 {
    public TreeNode searchBST(TreeNode root, int val) {
//        if(root==null || root.val==val) return root;
//        else if(root.val>val) return searchBST(root.left,val);
//        else if(root.val<val) return searchBST(root.right,val);
//        return null;
        if(root==null) return null;
        if(root.val==val) return root;
        if(root.val>val) return searchBST(root.left,val);
        return searchBST(root.right,val);

}
}
