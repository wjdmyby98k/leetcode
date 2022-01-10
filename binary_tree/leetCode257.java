package binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author：THIEM
 * @create:2021/9/6-15:40
 * 这题和93的不同之处在于，不能只用StringBuffer，因为你不知道到底数字有几位，不清楚怎么删除回溯的位数
 * 总结，知道回溯的位数的情况下，可以用StringBuffer，不然统统用LinkedList
 */
public class leetCode257 {
    List<String> result = new ArrayList<>();
    LinkedList path=new LinkedList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return result;
        backtracking(root);
        return result;
    }

    public void backtracking(TreeNode root) {
        if (root.left == null && root.right == null) {
            StringBuffer sb = new StringBuffer();
            for(int i=0;i<path.size();i++){
                sb.append(path.get(i));
            }
            sb.append(root.val);  //回溯的时候，最后一个数不用管
            result.add(sb.toString());
            return;
        }
        if (root.left != null) {
            path.add(root.val);
            path.add("->");
            backtracking(root.left);
            path.removeLast();   //回溯
            path.removeLast();
        }
        if (root.right != null) {
            path.add(root.val);
            path.add("->");
            backtracking(root.right);
            path.removeLast();  //回溯
            path.removeLast();
        }
    }
}
