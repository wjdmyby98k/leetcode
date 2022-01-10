package binary_tree;

/**
 * @author：THIEM
 * @create:2021/8/20-10:30
 * 116和117的解题是一样的（就是一道题），进阶需要常数空间复杂度。进阶难一点！！！
 */
public class leetCode117 {
    //设置一个dummy head
    public Node1 connect(Node1 root) {
        Node1 head=new Node1(0);
        Node1 cur=root;
        Node1 preNode = head; //放在外面，
        if(root==null) return root;
        while(true){
//            Node1 preNode = head;
            while(cur!=null){
                if(cur.left!=null){      //结点右移，每一层都相当于一个链表
                    preNode.next=cur.left;
                    preNode=preNode.next;
                }
                if(cur.right!=null){
                    preNode.next=cur.right;
                    preNode=preNode.next;
                }
                cur=cur.next;
            }
            cur=head.next;
            head.next=null;//断开虚拟结点的链接
            preNode=head; //然后再转换回来，免得每次循环里面都声明一个变量
            if(cur==null) break;;
        }
        return root;
    }
//    //官方解法
//    //handle函数的作用，①找到下一层链表的起点，②完成下一层的next操作，即穿针引线
//    Node1 last = null, nextStart = null;
//
//    public Node1 connect(Node1 root) {
//        if (root == null) {
//            return null;
//        }
//        Node1 start = root;
//        while (start != null) {
//            last = null;
//            nextStart = null;
//            for (Node1 p = start; p != null; p = p.next) {
//                if (p.left != null) {
//                    handle(p.left);
//                }
//                if (p.right != null) {
//                    handle(p.right);
//                }
//            }
//            start = nextStart;
//        }
//        return root;
//    }
//
//    public void handle(Node1 p) {
//        if (last != null) {
//            last.next = p;
//        }
//        if (nextStart == null) {
//            nextStart = p;
//        }
//        last = p;
//    }

}
