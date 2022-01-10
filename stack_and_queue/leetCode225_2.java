package stack_and_queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author：THIEM
 * @create:2021/8/10-21:01
 * 用两个deque，ArrayDeque实现类
 * 和方法一的区别其实就在于，一个是放入的时候摆好顺序，一个是取出来的时候摆好顺序，仔细体会。
 */
public class leetCode225_2 {

}
class MyStack1 {
    // Deque 接口继承了 Queue 接口
    // 所以 Queue 中的 add、poll、peek等效于 Deque 中的 addLast、pollFirst、peekFirst
    Deque<Integer> que1; // 和栈中保持一样元素的队列
    Deque<Integer> que2; // 辅助队列
    /** Initialize your data structure here. */
    public MyStack1() {
        que1 = new ArrayDeque<>();
        que2 = new ArrayDeque<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        que1.addLast(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int size = que1.size();
        size--;
        // 将 que1 导入 que2 ，但留下最后一个值
        while (size-- > 0) {
            que2.addLast(que1.peekFirst());//这里也可以简化，下一步是多余的
            que1.pollFirst();
        }

        int res = que1.pollFirst();
        // 将 que2 对象的引用赋给了 que1 ，此时 que1，que2 指向同一个队列
        que1 = que2;
        // 如果直接操作 que2，que1 也会受到影响，所以为 que2 分配一个新的空间
        que2 = new ArrayDeque<>();
        return res;
    }

    /** Get the top element. */
    public int top() {
        return que1.peekLast();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return que1.isEmpty();
    }
}
