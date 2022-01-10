package linkedList;

/**
 * @author：THIEM
 * @create:2021/7/14-9:44
 * 判断链表相交
 */
public class interview02_07 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA=0;
        int lenB=0;

        //ergodic A,B,save length
        for(ListNode cur=headA;cur!=null;cur=cur.next){
            lenA++;
        }
        for(ListNode cur=headB;cur!=null;cur=cur.next){
            lenB++;
        }

        ListNode curA=headA;
        ListNode curB=headB;

        //guarantee A is the longer link
        if(lenB>lenA){
            ListNode tempNode=curA;
            curA=curB;
            curB=tempNode;

            int temp=lenA;
            lenA=lenB;
            lenB=temp;
        }
        int gap=lenA-lenB;
        while(gap-->0){
            curA=curA.next;
        }
        while(curA!=null){
            if(curA==curB){
                return curA;
            }
            curA=curA.next;
            curB=curB.next;

        }
        return null;
    }
}
