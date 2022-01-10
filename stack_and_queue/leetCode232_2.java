package stack_and_queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author：THIEM
 * @create:2021/8/10-17:30
 * 用deque的api实现
 * 这里采用尾插
 *
 * 既然是两个栈模拟，倒腾的时候就要保证两个栈的元素的顺序是相反的，但不是相反也能做
 */
public class leetCode232_2 {
    class MyQueue {
        //队列里面两个栈类型变量
        Deque<Integer> stIn;
        Deque<Integer> stOut;
        /** Initialize your data structure here. */
        public MyQueue() {
            this.stIn=new ArrayDeque<>();
            this.stOut=new ArrayDeque<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            stIn.addLast(x);  //123
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if(stOut.isEmpty()){
                while(!stIn.isEmpty()){
                    stOut.addLast(stIn.pollLast());  //321
                    //addLast和add是等效的
                }
            }
            return stOut.pollLast();
        }

        /** Get the front element. */
        public int peek() {
            int res=this.pop();
            stOut.addLast(res);
            return res;
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stIn.isEmpty() && stOut.isEmpty();
        }
    }
}
