package linkedList;

/**
 * @author：THIEM
 * @create:2021/7/11-16:07
 * reverse linkedList
 * ListNode在203已结定义过了
 */

public class leetCode206 {
    public ListNode reverseList(ListNode head) {
        ListNode cur=head;
        ListNode prev=null;
        while(cur!=null){
            ListNode temp=cur.next;  // 保存一下 cur的下一个节点，因为接下来要改变cur->next
            cur.next=prev;           // 翻转操作,相当于把cur这个结点从链表中拿出来

            prev=cur;                  // 更新pre 和 cur指针
            cur=temp;
        }

        return prev;
    }
}
