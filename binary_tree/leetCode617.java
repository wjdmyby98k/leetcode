package binary_tree;

/**
@author：THIEM
@create:2021/9/13-15:52
 递归写
*/
public class leetCode617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return buildTree(root1,root2);
    }
    public TreeNode buildTree (TreeNode root1,TreeNode root2){
        if(root1==null && root2==null){
            return null;
        }
        else if(root1==null && root2!=null){
            TreeNode node =new TreeNode(root2.val);  //这tm直接return root2啊，笨比
            node.left=buildTree(null,root2.left);
            node.right=buildTree(null,root2.right);
            return node;
        }
        else if(root1!=null && root2==null){     //这tm直接return root1啊，笨比
            TreeNode node =new TreeNode(root1.val);
            node.left=buildTree(root1.left,null);
            node.right=buildTree(root1.right,null);
            return node;
        }
        TreeNode node =new TreeNode(root1.val+root2.val);
        node.left=buildTree(root1.left,root2.left);
        node.right=buildTree(root1.right,root2.right);
        return node;

    }
}
