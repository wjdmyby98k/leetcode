package daily_one_problem;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author：THIEM
 * @create:2021/12/13-19:56
 * (a*b) % k == ((a%k) * (b%k) )%k
 */
public class leetCode372 {
    int base = 1337;
    public int superPow(int a, int[] b) {
        Deque<Integer> queue = new ArrayDeque<>();

        for(int num : b)
            queue.addLast(num);
        return superPow(a, queue);
    }

    private int superPow(int a, Deque<Integer> queue){
        if(queue.isEmpty())
            return 1;

        int lastBit = queue.removeLast(); // 检索并移除最后一个元素

        int part1 = myPow(a, lastBit);
        int part2 = myPow(superPow(a, queue), 10);

        return (part1 * part2) % base;
    }

    // (a * b) % k = [(a % k) * (b % k)] % k
    /*
        假设 这个函数 已经 返回 mod k 的结果
    */
    private int myPow(int a, int b){
        if(b == 0)
            return 1;

        if(b % 2 == 0)
            return myPow( ((a % base) * (a % base)) % base, b / 2); // 公式推导的
        else
            return (  (a % base) * myPow(a, b - 1)  ) % base;
    }


}
