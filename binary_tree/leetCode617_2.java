package binary_tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author：THIEM
 * @create:2021/9/13-16:08
 * 用迭代写，迭代就是用队列模拟，同时进同时出,用递归写的话，就一定要注意，只在一棵树上进行操作就行了！
 * 思考：如果想用迭代在新建一棵树，好像是不太行？得用额外的数组把每个结点存起来，再建树,而且要区分左右？
 */
public class leetCode617_2 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null){
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        Deque<TreeNode> deque1=new LinkedList<>();
        Deque<TreeNode> deque2=new LinkedList<>();
        deque1.offer(root1);
        deque2.offer(root2);
        while (!deque1.isEmpty() || !deque2.isEmpty()){   //其实只需要一个队列就行了，用栈做其实也行
            TreeNode node1=deque1.poll();
            TreeNode node2=deque2.poll();
            node1.val+=node2.val;
            if(node1.left!=null && node2.left!=null){   //两个都不是空就加加进去
                deque1.offer(node1.left);
                deque2.offer(node2.left);

            }else {
                //else里面肯定都是存在一个空了
                // 因为我们是在root1的基础上修改，所以如果root1.left是null就直接把root2.left给他就行
                //哪怕root2.left也是空
                if(node1.left==null){
                    node1.left=node2.left;
                }
            }
            if(node1.right!=null && node2.right!=null){
                deque1.offer(node1.right);
                deque2.offer(node2.right);
            }else {
                if(node1.right==null){
                    node1.right=node2.right;
                }
            }
        }
        return root1;  //最后返回我们在root1基础上修改的树就行
    }
}
