package daily_one_problem;

/**
 * @author：THIEM
 * @create:2021/11/18-0:28
 */
public class leetCode563_2 {
    int ans=0;
    public int findTilt(TreeNode root) {
        if(root==null) return 0;
        dfs(root);
        return ans;
    }
    public int dfs(TreeNode node ){  // 计算以node为根节点的所有节点和
        if(node==null) return 0;
        int sumLeft=dfs(node.left);
        int sumRight=dfs(node.right);
        ans+= Math.abs(sumLeft-sumRight);
        return sumLeft+sumRight+node.val;// 这里为什么要加上node.val，理由如上
    }
}
