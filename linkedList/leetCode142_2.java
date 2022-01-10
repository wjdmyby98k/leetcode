package linkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * @author：THIEM
 * @create:2021/7/14-21:36
 * 利用set实现，简单很多，但是空间时间都不行
 */
public class leetCode142_2 {
    public ListNode detectCycle(ListNode head) {
        Set set=new HashSet();

        for(ListNode cur=head;cur!=null;cur=cur.next){
            if(set.contains(cur)){
                return cur;
            }else{
                set.add(cur);
            }
        }
        return null;

    }
}
