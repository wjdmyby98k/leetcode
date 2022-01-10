package daily_one_problem;

import java.util.HashSet;
import java.util.Random;

/**
 * @author：THIEM
 * @create:2021/11/29-14:41 二维坐标到一维的映射
 */
public class leetCode519 {

}

class Solution1 {
    int m;
    int n;
    int size;
    HashSet<Integer> set = new HashSet<>();
    Random random = new Random();

    public Solution1(int m, int n) {
        this.m = m;
        this.n = n;
        this.reset();
    }

    public int[] flip() {
        int x = random.nextInt(size);
        while (set.contains(x)) { // 主要这里的while耗时
            x = random.nextInt(size);
        }
        set.add(x);
        return new int[]{x / n, x % n}; // 二维坐标到一维坐标的映射
    }

    public void reset() {
        set.clear();
        size = m * n;
    }
}
