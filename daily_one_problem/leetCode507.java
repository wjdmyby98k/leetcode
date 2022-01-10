package daily_one_problem;

/**
 * @author：THIEM
 * @create:2021/12/31-14:46
 * 因为1要返回false。所以大于1的数，就从2开始考虑for loop
 */
public class leetCode507 {
    public boolean checkPerfectNumber(int num) {
        if (num == 1) return false;
        int ans = 1;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                ans += i;
                if (i * i != num) {
                    ans += num / i;
                }
            }
        }
        return ans == num;
    }
}
