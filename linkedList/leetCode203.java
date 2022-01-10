package linkedList;

/**
 * @author：THIEM
 * @create:2021/7/10-17:06
 */
//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class leetCode203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode header = new ListNode(-1);
        header.next = head;    //添加一个虚拟头结点,val随便设就行，题目要求查询的val是正的，所以设为负的
        ListNode cur = header;
        while(cur.next != null){
            if(cur.next.val == val ){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return header.next;
    }
}
