package binary_tree;

import java.util.Arrays;

/**
 * @author：THIEM
 * @create:2021/9/12-17:38
 * 每次都构建数组，逻辑清晰
 */
public class leetCode654_2 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums);
    }
    public TreeNode buildTree(int[] nums){
        if(nums.length==0){
            return null;
        }
        if(nums.length==1){
            return new TreeNode(nums[0]);

        }
        int maxValue=0;
        int maxValueIndex=0;
        for(int i=0;i<nums.length;i++){
            if (nums[i]>maxValue){
                maxValue=nums[i];
                maxValueIndex=i;
            }
        }
        TreeNode root= new TreeNode(maxValue);
        int[] leftNums= Arrays.copyOfRange(nums,0,maxValueIndex);
        int[] rightNums=Arrays.copyOfRange(nums,maxValueIndex+1,nums.length);
        root.left=buildTree(leftNums);
        root.right=buildTree(rightNums);
        return root;
    }
}
