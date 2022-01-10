package binary_tree;

/**
 * @author：THIEM
 * @create:2021/9/17-15:14
 * 修剪树不应该改变保留在树中的元素的相对结构
 * 递归一定要用宏观逻辑去看。
 * 递归的返回值，是找到符合条件的头结点！！！
 * 太难了，多看几遍吧
 */
public class leetCode669 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        //终止条件
        if(root==null) return null;
        //单层逻辑
        if(root.val<low){
            return trimBST(root.right,low,high);  //往右边找符合条件的头结点
        }
        if(root.val>high){
            return trimBST(root.left,low,high);  //往左边找符合条件的头结点
        }
        root.left=trimBST(root.left,low,high);
        root.right=trimBST(root.right,low,high);
        return root;
    }
}
