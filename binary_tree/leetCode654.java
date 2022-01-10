package binary_tree;

/**
 * @author：THIEM
 * @create:2021/9/12-17:21
 * 优化版本，直接传下标
 */
public class leetCode654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums,0,nums.length);
    }
    public TreeNode buildTree(int[] nums,int leftIndex,int rightIndex){
        if(rightIndex-leftIndex<1){   //没有元素了
            return null;
        }
        if(rightIndex-leftIndex==1){   //只有一个元素
            return new TreeNode(nums[leftIndex]);
        }
        // 找到最大值和索引
        int maxValue=nums[leftIndex];
        int maxValueIndex=leftIndex;
        for(int i=leftIndex+1;i<rightIndex;i++){
            if(nums[i]>maxValue){
                maxValue=nums[i];
                maxValueIndex=i;
            }
        }
        //构建根节点
        TreeNode root=new TreeNode(maxValue);
        root.left=buildTree(nums,leftIndex,maxValueIndex);
        root.right=buildTree(nums,maxValueIndex+1,rightIndex);
        return root;
    }
}
