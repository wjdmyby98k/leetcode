package linkedList;

import java.util.Stack;

/**
 * @author：THIEM
 * @create:2021/7/13-18:38
 * 用栈实现，当时是O（n）,leetCode双50，可能是栈开销太大？
 */
public class leetCode234_2 {
    public boolean isPalindrome(ListNode head) {
        boolean flag=true;
        Stack stack=new Stack();
        for(ListNode cur=head;cur!=null;cur=cur.next){
            stack.push(cur.val);
        }
        for(ListNode cur=head;cur!=null;cur=cur.next){
            if((int)stack.pop()!=cur.val){
                flag=false;
                break;
            }
        }

        return flag;

    }
}
