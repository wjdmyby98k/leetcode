package stack_and_queue;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author：THIEM
 * @create:2021/8/10-15:28
 *用两个栈实现队列
 *
 * 用stack的同名方法实现，但是java的stack已经过时了
 * 这里是采用头插的方式，放元素到第一个栈，在deque里面pop就是弹出第一个元素。
 */
public class leetCode232 {
    @Test
    public void Test(){
        MyQueue myQueue=new MyQueue();

    }
    class MyQueue {
        // java中的 Stack 有设计上的缺陷，官方推荐使用 Deque(双端队列) 代替 Stack
        Deque<Integer> stIn;
        Deque<Integer> stOut;
        /** Initialize your data structure here. */
        public MyQueue() {
            stIn = new ArrayDeque<>();
            stOut = new ArrayDeque<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            stIn.push(x); //这里是头插  321
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            // 只要 stOut 为空，那么就应该将 stIn 中所有的元素倒腾到 stOut 中
            if (stOut.isEmpty()) {
                while (!stIn.isEmpty()) {
                    stOut.push(stIn.pop());  //123
                }
            }
            // 再返回 stOut 中的元素
            return stOut.pop();
        }

        /** Get the front element. */
        public int peek() {
            // 直接使用已有的pop函数
            int res = this.pop();
            // 因为pop函数弹出了元素res，所以再添加回去
            stOut.push(res);
            return res;
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            // 当 stIn 栈为空时，说明没有元素可以倒腾到 stOut 栈了
            // 并且 stOut 栈也为空时，说明没有以前从 stIn 中倒腾到的元素了
            return stIn.isEmpty() && stOut.isEmpty();
        }
    }

}
