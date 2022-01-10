package linkedList;

/**
 * @author：THIEM
 * @create:2021/7/13-18:06
 * 判断回文链表
 * O（n）和O（1）
 * 因为要用0（1）的空间，所以需要多遍历几遍，先找中间的结点，再反转后半部分，将反转后的数据和前半段遍历比较，即可
 */
public class leetCode234 {
    public boolean isPalindrome(ListNode head) {
        boolean flag=true;
        if(head.next==null){
            return flag;
        }
        //consider only two node
        else if(head.next.next==null){
            if(head.val!=head.next.val){
                flag=false;
                return flag;
            }
        }else {
            //first find millde node

            ListNode fast=head;
            ListNode slow=head;
            while(fast!=null){
                fast=fast.next.next;
                slow=slow.next;
                if(fast.next==null || fast.next.next==null){
                    break;
                }
            }
            ListNode middleNode=slow;  // don't need consider odd,even,just reverse node after middleNode,
            // then ergodic the second half,because the first half is shorter

            ListNode afterMiddleNode =middleNode.next;  //record first node after middleNode

            middleNode.next=null;      //cut linkList after middleNode

            ListNode newHead=reverse(afterMiddleNode);
            for(ListNode cur=newHead;cur!=null;cur=cur.next){
                if(cur.val!=head.val){
                    flag=false;
                    break;
                }
                head=head.next;
            }

        }
        return flag;

    }
    public ListNode reverse (ListNode head){
        ListNode prev=null;
        ListNode cur=head;
        while(cur!=null){
            ListNode temp=cur.next;
            cur.next=prev;

            prev=cur;
            cur=temp;
        }
        return prev;
    }


}
