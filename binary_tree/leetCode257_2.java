package binary_tree;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author：THIEM
 * @create:2021/9/6-16:31
 * 用迭代写,层序遍历，每一层左右两条路径
 */
public class leetCode257_2 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result =new ArrayList<>();  //存放结果
        if(root==null) return result;
        Deque<TreeNode> deque=new LinkedList();  //遍历结点
        Deque<String> pathSt = new LinkedList<>();  //遍历路径
        deque.add(root);
        pathSt.add(Integer.toString(root.val));
        while(!deque.isEmpty()){
            TreeNode node = deque.poll();
            String path = pathSt.poll();   //这里用poll的意义是，栈里面每个字符串都是一个路径
            if(node.left==null && node.right==null){  //叶子结点
                result.add(path);
            }
            if(node.left!=null){
                deque.add(node.left);
                pathSt.add(path+"->"+node.left.val);
            }
            if(node.right!=null){
                deque.add(node.right);
                pathSt.add(path+"->"+node.right.val);
            }
        }
        return result;
    }
}
