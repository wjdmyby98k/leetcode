package binary_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author：THIEM
 * @create:2021/9/14-15:23
 * 这里有个误区，左子树全部都小于根节点，右子树也全部大于根节点，然后左右子树都是二差搜索树。
 * 用中序写一写试试
 */
public class leetCode98 {
    List<Integer> list= new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        traversal(root);
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i)>=list.get(i+1)){
                return false;
            }
        }
        return true;
    }
    public void traversal(TreeNode root){  //中序遍历，把结果用数组存起来
        if(root==null) return;
        traversal(root.left);
        list.add(root.val);
        traversal(root.right);
        return;
    }
}
