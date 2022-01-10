package binary_tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author：THIEM
 * @create:2021/9/1-16:24
 * 层序遍历写
 */
public class leetCode559 {
    public int maxDepth(Node root) {
        if(root==null) return 0;
        int depth=0;
        Deque<Node> deque=new LinkedList<>();
        deque.push(root);
        while(!deque.isEmpty()){
            int size=deque.size();

            for(int i=0;i<size;i++){
                Node node =deque.poll();
                if(node.children!=null){
                    for(Node node1:node.children){
                        deque.add(node1);
                    }
                }
            }
            depth++;
        }
        return depth;
    }
}
