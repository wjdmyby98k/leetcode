package linkedList;

/**
 * @author：THIEM
 * @create:2021/7/14-0:33
 * 增加虚拟头结点，开始时fast移动n+1步，然后fast和slow同时移动，直到fast==null，此时slow后面一个即为要删除的结点
 *
 * 虚拟头结点不用考虑空结点的问题，最后返回header.next即可，不要再返回head了！！！
 */
public class leetCode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode header=new ListNode(-1);
        header.next=head;



        ListNode fast=header;
        ListNode slow=header;

        for(int i=0;i<n+1;i++){
            fast=fast.next;
        }
        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;

        return header.next;

    }
}
