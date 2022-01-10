package daily_one_problem;


/**
 * @author：THIEM
 * @create:2021/11/16-19:19 两个链表相加，并返回一个链表
 * 这里重新写一个链表定义，就不放在carl刷题栏里面了，放在每日一题里面
 * 这题可以补0，也可以不补0，这里没补0
 */
public class leetCode2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(-1);
        ListNode head = l3;
        boolean carry = false;
        int sum;
        while (l1 != null || l2 != null) {  //有一个不为空就要相加
            sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            if (carry) {
                sum++;
            }
            head.next = new ListNode(sum % 10);
            head = head.next;
            carry = sum >= 10;  // 等号别忘了
        }
        if (carry) {
            head.next = new ListNode(1);
        }
        return l3.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

