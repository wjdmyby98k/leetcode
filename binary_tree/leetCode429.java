package binary_tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author：THIEM
 * @create:2021/8/19-22:18
 * 这里是层序遍历，carl手误，写错了
 */
class Node {
    public int val;
    public List<Node> children;
    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
public class leetCode429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null) return result;
        Deque<Node> deque=new LinkedList<>();
        deque.offer(root);
        while(!deque.isEmpty()){
            int size=deque.size();
            List<Integer> item=new ArrayList<>();
            for(int i=0;i<size;i++){
                Node node=deque.poll();
                item.add(node.val);
//                for(Node child:node.children){
//                    deque.offer(child);
//                }
                deque.addAll(node.children);

            }
            result.add(item);
        }
        return result;
    }
}

