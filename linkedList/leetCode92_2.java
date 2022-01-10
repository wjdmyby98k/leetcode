package linkedList;

/**
 * @author：THIEM
 * @create:2021/7/14-8:46
 * 改进方式：①增加虚拟头结点  ②改用头插，找到left-1的元素，然后将left后面的元素一个一个的插入到left-1后面，直到right
 *
 * 只需要遍历一遍
 */
public class leetCode92_2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode header=new ListNode(-1);
        header.next=head;

        ListNode cur=header;
        for(int i=0;i<left-1;i++){
            cur=cur.next;
        }
        ListNode prev=cur;
        ListNode succ=cur.next;

        for(int i=0;i<right-left;i++){     // only insert right-left times
            ListNode temp=succ.next;
            succ.next=succ.next.next;

            temp.next=prev.next;           //note:don't use succ,because prev.next=succ only in the first time
            prev.next=temp;

        }
        return header.next;
    }

}
