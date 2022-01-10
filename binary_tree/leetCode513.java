package binary_tree;

/**
 * @author：THIEM
 * @create:2021/9/6-20:13
 * 递归写,好像要用回溯，因为要找最左边的值，不用回溯好像得用后序遍历的统一迭代去写
 * 回溯的逻辑:从左边开始一条一条的找，找到叶子结点的时候，更新深度，同时记录值，以后再遇到用到深度的时候，不记录值
 */
public class leetCode513 {
    int maxLen=0;
    int maxLeftValue=0;
    public int findBottomLeftValue(TreeNode root) {   //题目说了root不为null，至少一个结点，不用判null
        backtracking(root,1);
        return maxLeftValue;
    }
    public void backtracking(TreeNode node,int leftLen){
        if(node.left==null && node.right==null){
            if(maxLen<leftLen){
                maxLen=leftLen;
                //第一次找到的最深的时候，就让最大深度更新，以后再到最深的时候，不可能有小于的情况（因为相等）
                maxLeftValue= node.val;  //第一次找到最深的时候，更新所需的结果
                return;
            }
        }

        if(node.left!=null){
            backtracking(node.left,leftLen+1);  //隐藏的回溯
        }
        if(node.right!=null){
            backtracking(node.right,leftLen+1);
        }

    }
}
