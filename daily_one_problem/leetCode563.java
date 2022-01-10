package daily_one_problem;

/**
 * @author：THIEM
 * @create:2021/11/18-0:12
 * 评论区大神，双递归，确实帅
 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(int val){
        this.val=val;
    }
    TreeNode(int val,TreeNode left,TreeNode right){
        this.val=val;
        this.left=left;
        this.right=right;
    }
}
public class leetCode563 {
    public int findTilt(TreeNode root) { // 求坡度，双递归
        if(root==null){
            return 0;
        }
        return Math.abs(sum(root.left)-sum(root.right))+findTilt(root.left)+findTilt(root.right);
    }
    public int sum(TreeNode node){   // 用来计算当前节点的   子节点和
        if(node==null){
            return 0;
        }
        return sum(node.left)+sum(node.right)+node.val;
    }
}
