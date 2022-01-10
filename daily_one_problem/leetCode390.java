package daily_one_problem;

/**
 * @author：THIEM
 * @create:2022/1/3-23:18 官方题解, k为偶数代表从左向右，为奇数则从右向左
 */
public class leetCode390 {
    public int lastRemaining(int n) {
        int a1 = 1, step = 1, k = 0;
        int cnt = n;
        while (cnt > 1) {
            if (k % 2 == 0) {
                a1 = a1 + step; // 这里加的是上一步的公差
            } else {
                a1 = cnt % 2 == 0 ? a1 : a1 + step; // 从右向左的时候就要看是奇数还是偶数，再考虑删不删除第一个数
            }
            k++;
            step = step << 1;  // 每次公差都是乘2
            cnt = cnt >> 1;   // 每次总数都输除2
        }
        return a1;    // 只剩最后一个数的时候返回
    }
}
