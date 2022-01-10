package stack_and_queue;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author：THIEM
 * @create:2021/8/10-18:24
 * 为什么要写的这么复杂？？？原因就是队列是单向队列，双向队列失去了这题的意义，直接调包就行。
 * 用队列实现栈
 * 用两个queue队列，并用linkedList实现类
 * poll()  检索并删除由此列表的头
 * peek()  检索但不删除此列表的头
 */
public class leetCode225 {
    @Test
    public void Test(){
        MyStack myStack=new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
    }

}
    class MyStack {

        Queue<Integer> queue1; // 和栈中保持一样元素的队列
        Queue<Integer> queue2; // 辅助队列

        /** Initialize your data structure here. */
        public MyStack() {
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            queue2.offer(x); // 先放在辅助队列中
            while (!queue1.isEmpty()){  //如果queue1不是空的话，就把头元素一个一个放在queue2的末尾
                queue2.offer(queue1.poll());
            }
            Queue<Integer> queueTemp;
            queueTemp = queue1;
            queue1 = queue2;
            queue2 = queueTemp; // 最后交换queue1和queue2，将元素都放到queue1中
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return queue1.poll(); // 因为queue1中的元素和栈中的保持一致，所以这个和下面两个的操作只看queue1即可
        }

        /** Get the top element. */
        public int top() {
            return queue1.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue1.isEmpty();
        }
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

