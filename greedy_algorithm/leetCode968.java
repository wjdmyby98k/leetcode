package greedy_algorithm;

/**
 * @author：THIEM
 * @create:2021/12/16-20:51
 * 贪心思想（不如说就该这么想）：从叶子结点开始遍历，使用后序遍历，叶子结点就放摄像头
 * 空节点默认为覆盖，只有这样才能保证空节点不受影响
 * 每个结点，只有三种状态：没有覆盖，有摄像头，被覆盖（但没摄像头）
 * 分别对应，0,1,2三种状态
 * 遍历过程中，每个节点也有三种情况
 * ①左右子节点都覆盖，那当前节点就是无覆盖状态
 * ②左右至少有一个没覆盖，那当前节点就是摄像头
 * ③左右至少有一个摄像头，那当前节点就是覆盖
 * ④头结点需要额外判断，如果头结点是没覆盖，需要额外加摄像头
 */
public class leetCode968 {
    int ans = 0;

    public int minCameraCover(TreeNode root) {
        if(traversal(root)==0){
            ans++;
        }
        return ans;
    }

    public int traversal(TreeNode cur) {
        if (cur == null) return 2;
        int left = traversal(cur.left);
        int right = traversal(cur.right);
        if (left == 2 && right == 2) {
            return 0;
        }
        if (left == 0 || right == 0) {
            ans++;
            return 1;
        }
        if (left == 1 || right == 1) {
            return 2;
        }
        return -1;  // 这里是为了满足语法，实际上不会走到这里
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
