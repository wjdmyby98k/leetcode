package stack_and_queue;
import org.junit.Test;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author：THIEM
 * @create:2021/8/10-23:59
 */
public class leetCode20 {
    @Test
    public void Test(){
        String s="]";
//        isValid(s);
    }
    public boolean isValid(String s) {
        Deque<Character> que=new LinkedList<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                que.push(')');
            }
            else if(s.charAt(i)=='['){
                que.push(']');
            }
            else if(s.charAt(i)=='{'){
                que.push('}');
            }
            else if(que.isEmpty() || s.charAt(i)!=que.peekFirst()){
                //因为基本数据类型不能和null比较，前面加个empty的判断是为了防止空指针异常
                return false;
            }
            else que.pop();
        }
        return que.isEmpty();
    }
}
