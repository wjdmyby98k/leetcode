package stack_and_queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author：THIEM
 * @create:2021/8/10-22:50
 * 用一个队列实现栈
 */
public class leetCode225_3 {
}
class MyStack2 {
    Deque<Integer> que1;
     /** Initialize your data structure here. */
     public MyStack2() {
         que1=new ArrayDeque<>();
     }

     /** Push element x onto stack. */
     public void push(int x) {
        que1.addLast(x);
     }

     /** Removes the element on top of the stack and returns that element. */
     public int pop() {
         int size=que1.size();
         size--;
         while(size-->0){
             que1.offer(que1.pollFirst());
         }
         int res=que1.pollFirst();
        return res;
     }

     /** Get the top element. */
     public int top() {
         return que1.peekLast(); //这里取元素和单向队列是不矛盾的
     }

     /** Returns whether the stack is empty. */
     public boolean empty() {
         return que1.isEmpty();
     }
 }
