package binary_tree;


/**
 * @author：THIEM
 * @create:2021/9/17-16:56
 * 迭代法思想，先找到符合条件的根节点
 * 处理左孩子的左节点，处理右孩子的右节点，
 * 因为是搜索二叉树，左边的要删除的节点，肯定是比根节点小，右边的肯定比根节点大
 * 其实没必要把多余的结点删掉，因为只需要返回符合条件的root节点，至于有没有节点指向root，都能过！！！
 */
public class leetCoe669_2 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        TreeNode parent=root;  //用来记录前一个节点，方便直接把树之间的联系删掉
        //先找到符合条件的根节点
        if(root==null) return null;
        if(root.val>=low && root.val<=high){

        }else {
            while(root!=null && (root.val<low || root.val>high)){
                if(root.val>high){
                    parent=root;
                    root=root.left;

                }else if(root.val<low){
                    parent=root;
                    root=root.right;
                }
            }
            //断绝符合条件的根节点与多余的节点的关系
            if(root!=null){
                if(parent.val>root.val){
                    parent.left=null;
                }else {
                    parent.right=null;
                }
            }

        }

        TreeNode cur=root;  //保存当前的根节点
        //去除左树小于low的孩子
        while(cur!=null){
            while(cur.left!=null && cur.left.val<low){
                cur.left=cur.left.right;
            }
            cur=cur.left;
        }
        //处理右边
        cur=root;
        while(cur!=null){
            while(cur.right!=null && cur.right.val>high){
                cur.right=cur.right.left;
            }
            cur=cur.right;
        }
        return root;
    }
}
