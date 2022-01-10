package stack_and_queue;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author：THIEM
 * @create:2021/8/11-10:25
 * 用一个deque实现
 *
 */
public class leetCode1047 {
    @Test
    public void Test(){
        String s="abbaca";
        String s1=removeDuplicates(s);
        System.out.println(s1);
    }
    public String removeDuplicates(String s) {
        Deque<Character> deque=new ArrayDeque<>();

        char[] chars=s.toCharArray();
        for(char c:chars){
            if(deque.isEmpty() || deque.peek()!=c){//加入元素的时候，一定要注意判断是否为空
                // 否则很容易出现空指针异常，而且不能反过来！
                deque.push(c);
            }
            else{
                deque.pop();
            }

        }
        String str = "";
        //剩余的元素即为不重复的元素
        while (!deque.isEmpty()) {
            str = deque.pop() + str;
        }
        return str;
    }
}
