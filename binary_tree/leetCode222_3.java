package binary_tree;

/**
 * @author：THIEM
 * @create:2021/9/3-15:43
 * 利用完全二叉树的特性写
 */
public class leetCode222_3 {
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int leftDepth=getDepth(root.left);
        int rightDepth=getDepth(root.right);
        if(leftDepth==rightDepth){   //是满二叉树
            return (1<<leftDepth)+countNodes(root.right);    //用到移位运算一定要用括号，优先级不够！
        }else {    //是完全二叉树，最后一层没满，倒数第二层左边是完全，右边是满
            return (1<<rightDepth)+countNodes(root.left);
        }
    }
    public int getDepth(TreeNode root){  //得到完全二叉树的深度只要遍历他的左子树就行！
        if(root==null) return 0;
        int depth=0;
        while(root!=null){
            root=root.left;
            depth++;
        }
        return depth;
    }
}
