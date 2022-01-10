package binary_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author：THIEM
 * @create:2021/8/19-0:58
 */
public class leetCode102_2 {
    //递归
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        recursive(root,0);
        System.out.println(result.size());
        return result;
    }
    public void recursive(TreeNode node,int deep){
        if(node==null) return;
        deep++;

        if(result.size()<deep){
            List<Integer> item=new ArrayList<>();
            result.add(item);
        }
        //每一次递归都要加数据，上面那个if可能是不成立的！！！
        result.get(deep-1).add(node.val);
        
        recursive(node.left,deep);
        recursive(node.right,deep);

    }
}
