package linkedList;

/**
 * @author：THIEM
 * @create:2021/7/11-18:22
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 * 反转链表，指定left和right，链表长度>=1，注意这里是位置left，不是第left个位置。
 * 先找到left前面那个结点，并保存，然后left开始一个一个反转，反转到cur==right对应的结点
 * left前面那个连接right对应的结点，left结点连接right后面的结点
 *
 * 这个遍历了两遍
 *
 */
public class leetCode92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // only one
        if(head.next==null || left==right) return head;
        ListNode cur;
        ListNode newHead=null;
        if(left==1){
            cur=head;
            for(int i=1;i<right;i++){
                cur=cur.next;   // right node
            }
            if(cur.next==null){   //reverse head and tail;
                 newHead=reverse(head);

            }else{
                ListNode afterRightNode=cur.next;
                cur.next=null;    //cut right
                newHead=reverse(head);
                head.next=afterRightNode;
            }
        }else{
            cur=head;
            for(int i=1;i<left-1;i++){
                cur=cur.next;    // behind left node
            }
            ListNode behindLeftNode=cur;
            ListNode leftNode=cur.next;
            behindLeftNode.next=null;  //cut left

            cur=leftNode;
            for(int i=0;i<right-left;i++){
                cur=cur.next;    //right node
            }
            if(cur.next==null){
                behindLeftNode.next=reverse(leftNode);
            }else{
                ListNode afterRightNode =cur.next;
                cur.next=null;    //cut right

                behindLeftNode.next=reverse(leftNode);
                leftNode.next=afterRightNode;
            }

            newHead=head;


        }
        return newHead;
    }
    public ListNode reverse(ListNode head){
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
