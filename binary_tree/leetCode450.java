package binary_tree;

/**
 * @author：THIEM
 * @create:2021/9/17-0:24
 * 二叉搜索树节点删除，情况比较多，想清楚
 * 返回根节点！！！
 * 带返回值的递归，就需要一个返回值去接受下一次的递归
 */
public class leetCode450 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        if(root.val==key){ // root.val==key
            if(root.left==null){
                return root.right;
            }else if(root.right==null){
                return root.left;
            }else{
                TreeNode cur = root.right;
                while(cur.left!=null){
                    cur=cur.left;     //找到最左边的节点
                }
                TreeNode temp=root.left;
                root.left=null;
                root=root.right;
                cur.left=temp;
            }
        }
        //上面全是终止条件，下面是单层循环逻辑。
        if(root.val>key) root.left=deleteNode(root.left,key);
        if(root.val<key) root.right=deleteNode(root.right,key);
        return root;
    }

}
