package daily_one_problem;

import java.util.HashMap;
import java.util.Random;

/**
 * @author：THIEM
 * @create:2021/11/30-16:43
 * 利用hashmap达到随机线性映射
 * 注意这里的size是全局变量！！！
 */
public class leetCode519_2 {

}

class Solution2 {
    int m;
    int n;
    int size;
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    Random random = new Random();

    public Solution2(int m, int n) {
        this.m = m;
        this.n = n;
        this.reset();
    }

    public int[] flip() {
        int x = random.nextInt(size--); //注意这里是要--的
        int y = hashMap.getOrDefault(x, x); // y代表是x的映射，
        hashMap.put(x, hashMap.getOrDefault(size, size));
        return new int[]{y / n, y % n};
    }

    public void reset() {
        hashMap.clear();
        size = m * n;
    }
}
