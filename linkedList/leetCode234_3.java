package linkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author：THIEM
 * @create:2021/7/13-18:49
 * 用list存数据，再双指针一头一尾，逐个比较
 */
public class leetCode234_3 {
    public boolean isPalindrome(ListNode head) {
        boolean flag=true;
        List nums=new ArrayList();
        for(ListNode cur=head;cur!=null;cur=cur.next){
            nums.add(cur.val);
        }
        ListNode cur=head;
        int left=0;
        int right=nums.size()-1;
        while(left<right){
            if(nums.get(left)!=nums.get(right)){
                flag=false;
                break;
            }
            left++;
            right--;
        }

        return flag;
    }

}
