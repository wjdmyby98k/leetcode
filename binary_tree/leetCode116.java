package binary_tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author：THIEM
 * @create:2021/8/19-23:03
 * 由于这里的Node已经定义在429定义过了，改为Node，提交 leetcode 注意下
 */
class Node1 {
    public int val;
    public Node1 left;
    public Node1 right;
    public Node1 next;

    public Node1() {}

    public Node1(int _val) {
        val = _val;
    }

    public Node1(int _val, Node1 _left, Node1 _right, Node1 _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

public class leetCode116 {
    //简化一下,也没简化多少，就是用preNode和Node的思想。
    public Node1 connect(Node1 root) {
        if(root==null) return null;
        Deque<Node1> deque=new LinkedList<>();
        deque.offer(root);
        while(!deque.isEmpty()){
            int size=deque.size();
            Node1 preNode=null; //这里一定要赋初值
            Node1 node=null;
            for(int i=0;i<size;i++){
                if(i==0){
                    preNode=deque.poll();
                    node=preNode;
                }else {
                    node=deque.peek();
                    preNode.next=deque.poll();
                    preNode=preNode.next;
                }
                if(node.left!=null) deque.offer(node.left);
                if(node.right!=null) deque.offer(node.right);
            }
        }
        return root;
    }
//    public Node1 connect(Node1 root) {
//        if(root==null) return null;
//        Deque<Node1> deque=new LinkedList<>();
//        deque.offer(root);
//        while(!deque.isEmpty()){
//            int size=deque.size();
//            for(int i=0;i<size;i++){
//                if(i==size-1){
//                    Node1 node=deque.poll();
//                    node.next=null;
//                    if(node.left!=null) deque.offer(node.left);
//                    if(node.right!=null) deque.offer(node.right);
//                    break;
//                }
//                Node1 node =deque.poll();
//                node.next=deque.peek();
//                if(node.left!=null) deque.offer(node.left);
//                if(node.right!=null) deque.offer(node.right);
//            }
//        }
//        return root;
//    }
}
