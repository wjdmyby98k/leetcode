package binary_tree;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author：THIEM
 * @create:2021/8/19-15:50
 */
public class leetCode199 {
    //简化版本
    public List<Integer> rightSideView(TreeNode root){
        List<Integer> result=new ArrayList<>();
        if(root==null) return result;
        Deque<TreeNode> deque=new LinkedList<>();
        deque.offer(root);
        while (deque.size()>0){
            int size=deque.size();
            for(int i=0;i<size;i++){
                TreeNode node=deque.poll();
                if(i==size-1){
                    result.add(node.val);
                }
                if(node.left!=null) deque.offer(node.left);
                if(node.right!=null) deque.offer(node.right);
            }
        }
        return result;
    }


//    public List<Integer> rightSideView(TreeNode root) {
//        List<List<Integer>> result=new ArrayList<>();
//        Deque<TreeNode> deque=new LinkedList<>();
//        if(root==null) return new ArrayList<Integer>();
//        deque.offer(root);
//        while(deque.size()>0){
//            int size=deque.size();
//            List<Integer> list=new ArrayList<>();
//            for(int i=0;i<size;i++){
//                TreeNode node=deque.poll();
//                list.add(node.val);
//                if(node.left!=null){
//                    deque.offer(node.left);
//                }
//                if(node.right!=null){
//                    deque.offer(node.right);
//                }
//            }
//            result.add(list);
//        }
//        List<Integer> ans=new ArrayList<>();
//        for(int i=0;i<result.size();i++){
//
//            ans.add(result.get(i).get(result.get(i).size()-1));
//        }
//        return ans;
//    }
}

