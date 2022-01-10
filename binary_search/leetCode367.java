package binary_search;

/**
 * @author：THIEM
 * @create:2022/1/9-15:09
 * 这种方式不用考虑那么多边界问题！
 */
public class leetCode367 {
    public boolean isPerfectSquare(int num) {
        long l = 0, r = num;
        while (l < r) {
            long mid = l + r + 1 >> 1;
            if (mid * mid <= num) l = mid;
            else r = mid - 1;
        }
        return r * r == num;
    }

}
