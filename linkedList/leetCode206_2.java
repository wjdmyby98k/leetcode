package linkedList;

/**
 * @author：THIEM
 * @create:2021/7/11-17:27
 * 用递归实现
 */
public class leetCode206_2 {
    public ListNode reverseList(ListNode head) {

        return reverse(null,head);
    }
    public  ListNode reverse(ListNode prev,ListNode cur){
        if(cur==null) return prev;
        ListNode temp=cur.next;
        cur.next=prev;
        return reverse(cur,temp);
    }

}
