package daily_one_problem;

/**
 * @author：THIEM
 * @create:2022/1/4-0:37
 * 三叶题解，有点数学了
 */
public class leetCode390_2 {
    public int lastRemaining(int n) {
        return n == 1 ? 1 : 2 * (n / 2 + 1 - lastRemaining(n / 2));
    }

}
