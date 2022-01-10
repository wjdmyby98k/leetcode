package binary_tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author：THIEM
 * @create:2021/9/16-9:34
 * 二叉搜索树的公共祖先比普通二叉树更好找，因为有方向，解法1再写一遍普通的二叉树，练练手感
 */
public class leetCode235 {
    HashMap<Integer,TreeNode> map=new HashMap<>();
    Set<Integer> visit=new HashSet<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        traversal(root);
        while(p!=null){
            visit.add(p.val);
            p=map.get(p.val);
        }
        while(q!=null){
            if(visit.contains(q.val)){
                return q;
            }
            q=map.get(q.val);
        }
        return null;
    }
    public void traversal(TreeNode root){
        if(root.left!=null){
            map.put(root.left.val,root);
            traversal(root.left);
        }
        if(root.right!=null){
            map.put(root.right.val,root);
            traversal(root.right);
        }
    }
}
