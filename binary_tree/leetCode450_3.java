package binary_tree;

import org.junit.Test;

import java.util.Stack;

/**
 * @author：THIEM
 * @create:2021/9/17-10:39
 * 迭代法试试，先找到要删的节点，想到用栈放
 * 如果要删的是根节点，返回的root就要变化，如果不是根节点，就直接删除再返回root
 * 终于找到问题的关键了，第五种情况，删除的时候，一定要记得记录他的父结点，再删除。
 */
public class leetCode450_3 {
    @Test
    public void Test(){
        TreeNode node50=new TreeNode(50);
        TreeNode node30=new TreeNode(30);
        TreeNode node60=new TreeNode(60);
        TreeNode node80=new TreeNode(80);
        TreeNode node40=new TreeNode(40);
        TreeNode node70=new TreeNode(70);
        node50.left=node30;
        node50.right=node70;

        node30.right=node40;
        node70.right=node80;
        node70.left=node60;
        deleteNode(node50,50);
        System.out.println(node50.right.val);
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        Stack<TreeNode> stack=new Stack<>();
        TreeNode parent=null;
        if(root==null) return null;
        if(root.val==key){
            if(root.left==null) return root.right;
            else if(root.right==null) return root.left;
            else {
                TreeNode right=root.right;
                while(right.left!=null){
                    right=right.left;
                }
                TreeNode left=root.left;
                root.left=null;
                right.left=left;
                root=root.right;
                //这里实际上没有把原来的根节点删掉，只是把root换到右边并返回
                return root;
            }
        }
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur=stack.pop();
            if(cur.val<key){
                if(cur.right!=null){
                    stack.push(cur.right);
                    parent=cur;
                }

            } else if (cur.val > key) {
                if(cur.left!=null){
                    stack.push(cur.left);
                    parent=cur;
                }
            }else {  //相等的情况
                if(cur.left==null && cur.right==null) {
                    if(parent.val>key){
                        parent.left=cur.right;
                    }else {
                        parent.right=cur.right;
                    }
                }
                else if(cur.left==null && cur.right!=null) {
                    if(parent.val>key){
                        parent.left=cur.right;
                    }else {
                        parent.right=cur.right;
                    }
                }
                else if(cur.left!=null && cur.right==null) {
                    if(parent.val>key){
                        parent.left=cur.left;
                    }else {
                        parent.right=cur.left;
                    }
                }
                else {
                    TreeNode node= cur.right;
                    while(node.left!=null){   //找到最左边的节点
                        node=node.left;
                    }
                    TreeNode temp=cur.left;
                    cur.left=null;
                    node.left=temp;
                    if(parent.val>cur.val){
                        parent.left=cur.right;
                    }else {
                        parent.right=cur.right;    //这里才是真正的删除了节点
                    }
                }
            }
        }
        return root;
    }
}
