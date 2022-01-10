package binary_tree;

/**
 * @author：THIEM
 * @create:2021/9/13-19:00
 * 用迭代写,这里有个细节，注意些逻辑的时候，注意不同的逻辑，一定要加个else，比如下面的不写else，if可能会执行两次！
 */
public class leetCode700_2 {
    public TreeNode searchBST(TreeNode root, int val) {
        while(root!=null){
            if(root.val==val) return root;
            if(root.val>val){
                root=root.left;
            }else if(root.val<val){
                root=root.right;
            }
        }
        return null;
    }
}
