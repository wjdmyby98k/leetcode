package stack_and_queue;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author：THIEM
 * @create:2021/8/15-14:36
 */
public class leetCode150 {
    @Test
    public void Test(){
        boolean ss=isOpe("0");
        System.out.println(ss);
    }
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack =new LinkedList<>();
        for(String s:tokens){
            if(isOpe(s)){
              if(s.equals("+")){
                  stack.push(stack.pop()+stack.pop());
              }else if(s.equals("-")){
                  stack.push(-stack.pop()+stack.pop());
              }else if(s.equals("*")){
                  stack.push(stack.pop()*stack.pop());
              }else {
                  int num1=stack.pop();
                  int num2=stack.pop();
                  stack.push(num2/num1);
              }
            }else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }
    public boolean isOpe(String s) {
        //这里要加一个判断长度是否为1，防止负数的时候判断错误，比如-11
        return s.length() == 1 && (s.charAt(0) <'0' || s.charAt(0) >'9');

    }
}
