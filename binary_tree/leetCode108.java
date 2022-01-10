package binary_tree;

/**
 * @author：THIEM
 * @create:2021/9/23-16:50
 * 递归，全局理解容易写！！！
 */
public class leetCode108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return traversal(nums,0,nums.length-1);
    }
    public TreeNode traversal(int[] nums,int left,int right){
        if(left>right) return null;
        int mid = left+(right-left)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left=traversal(nums,left,mid-1);
        root.right=traversal(nums,mid+1,right);
        return root;
    }
}
