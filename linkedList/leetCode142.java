package linkedList;

/**
 * @author：THIEM
 * @create:2021/7/14-18:54
 * 找到环形链表的，成环的地方
 * 思路，一快一慢，快指针每次两步，慢指针一次一步，有环就一定会相遇，相遇以后，再定义两指针，一个在头，一个在相遇，同时遍历
 * 最后这两个指针会在成环的那里==
 *
 */
public class leetCode142 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){   // in case of nullPointer exception
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                ListNode meetNode=fast;
                ListNode cur=head;
                while(cur!=meetNode){
                    cur=cur.next;
                    meetNode=meetNode.next;
                }
                return cur;
            }
        }

        return null;
    }
}
