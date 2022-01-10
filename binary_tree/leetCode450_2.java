package binary_tree;

import org.junit.Test;

/**
 * @author：THIEM
 * @create:2021/9/17-9:19
 * 不带返回值的递归，试试,太笨比了，击败10%
 */
public class leetCode450_2 {
    @Test
    public void Test(){
        TreeNode node5=new TreeNode(5);
        TreeNode node3=new TreeNode(3);
        TreeNode node6=new TreeNode(6);
        TreeNode node2=new TreeNode(2);
        TreeNode node4=new TreeNode(4);
        TreeNode node7=new TreeNode(7);
        node5.left=node3;
        node5.right=node6;
        node3.left=node2;
        node3.right=node4;
        node6.right=node7;
        deleteNode(node5,3);
    }
    TreeNode parent;
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return null;
        }
        if(root.val==key){
            if(root.left==null) return root.right;
            else if(root.right==null) return root.left;
            else {
                TreeNode cur=root.right;
                while(cur.left!=null){
                    cur=cur.left;
                }
                TreeNode temp =root.left;
                root.left=null;
                root=root.right;
                cur.left=temp;
                return root;
            }
        }

        delete(root,key);
        return root;
    }
    public void delete(TreeNode root,int key){
        if(root==null) return;

        if(root.val==key){
            if(root.left==null && root.right==null){   //都空
                if(parent.val>root.val){
                    parent.left=null;
                }else {
                    parent.right=null;
                }
            }else if(root.right==null && root.left!=null){   //右空
                if(parent.val>key){
                    parent.left=root.left;
                }else {
                    parent.right=root.left;
                }
            }else if(root.left==null && root.right!=null){// 左空
                if(parent.val>key){
                    parent.left=root.right;
                }else {
                    parent.right=root.right;
                }
            }else {  // 都不空
                TreeNode cur=root.right;
                while(cur.left!=null){
                    cur=cur.left;
                }
                TreeNode temp=root.left;
                root.left=null;
                cur.left=temp;
                if(parent.val>key){
                    parent.left=root.right;
                }else {
                    parent.right=root.right;
                }
            }
        }
        parent=root;
        if(root.val>key) delete(root.left,key);
        if(root.val<key) delete(root.right,key);
    }
}
