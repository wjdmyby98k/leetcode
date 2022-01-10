package binary_tree;

import java.util.Arrays;

/**
 * @author：THIEM
 * @create:2021/9/11-20:01
 * 没有优化的版本，每次数组都提前分割好，面试的时候，肯定先要这样写，再慢慢优化
 */
public class leetCode106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree1(inorder,postorder);
    }
    public TreeNode buildTree1(int[] inorder,int[] postorder){
        //第一步，终止条件，数组长度为0，就return null
        if(inorder.length==0){
            return null;
        }
        //第二步，取出根节点
        int val=postorder[postorder.length-1];
        TreeNode root=new TreeNode(val);
            //如果数组长度为1，就说明是叶子结点，也返回
        if(inorder.length==1){
            return root;
        }
        //第三步，找到根节点在中序数组中的位置，
        int index=0;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==val){
                index=i;
                break;
            }
        }
        //第四步，分割中序左数组和中序右数组
        int[] leftInorder=Arrays.copyOfRange(inorder,0,index);
        int[] rightInorder= Arrays.copyOfRange(inorder,index+1,inorder.length);
        //第五步，分割后序左和后序右，注意左右长度要对应,保证左中和左后长度一样，右同理，注意下面是从index开始
        int[] leftPostorder=Arrays.copyOfRange(postorder,0,index);
        int[] rightPostorder=Arrays.copyOfRange(postorder,index,postorder.length-1);
        //第六步，递归
        root.left=buildTree1(leftInorder,leftPostorder);
        root.right=buildTree(rightInorder,rightPostorder);
        return root;
    }
}
