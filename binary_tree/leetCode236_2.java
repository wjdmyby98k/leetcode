package binary_tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author：THIEM
 * @create:2021/9/16-0:51 用hashmap写，hashmap存储每个结点的值，以及他的父亲
 * 分别从p和q往上找父结点
 * hashmap里面get方法，不存在key的时候，会返回null
 */
public class leetCode236_2 {
    HashMap<Integer, TreeNode> map = new HashMap<>();
    List<Integer> used = new ArrayList<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        traversal(root);
        while (p != null) {
            used.add(p.val);  //把p的值放进used列表
            p = map.get(p.val); //p向上找父结点
        }
        //退出循环的时候，刚好是根节点被加进去
        while (q != null) {
            if (used.contains(q.val)) {
                return q;
            }
            q = map.get(q.val);

        }
        return null;
    }

    public void traversal(TreeNode root) {
        if (root.left != null) {
            map.put(root.left.val, root);
            traversal(root.left);
        }
        if (root.right != null) {
            map.put(root.right.val, root);
            traversal(root.right);
        }
    }
}
