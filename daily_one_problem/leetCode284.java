package daily_one_problem;

import java.util.Iterator;

/**
 * @author：THIEM
 * @create:2021/11/16-9:47
 * 倒也不是让你从头设计一个迭代器！！！！
 * 请你在设计一个迭代器，在集成现有迭代器拥有的 hasNext 和 next 操作的基础上，还额外支持 peek 操作。
 * 实现 PeekingIterator 类：
 * PeekingIterator(Iterator<int> nums) 使用指定整数迭代器nums 初始化迭代器。
 * int next() 返回数组中的下一个元素，并将指针移动到下个元素处。
 * bool hasNext() 如果数组中存在下一个元素，返回 true ；否则，返回 false 。
 * int peek() 返回数组中的下一个元素，但 不 移动指针。
 * 注意：每种语言可能有不同的构造函数和迭代器，但均支持 int next() 和 boolean hasNext() 函数。
 */
public class leetCode284 {

}
class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iter;
    Integer next; //next记录的就是下一个元素
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iter=iterator;
        if(this.iter.hasNext()){
            this.next=this.iter.next(); // 这里初始化相当于是返回第一个元素
        }

    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer ans=next;
        //移动指针
        next=iter.hasNext()?iter.next():null;
        return ans;
    }

    @Override
    public boolean hasNext() {
        return next!=null;
    }
}
