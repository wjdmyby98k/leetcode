package daily_one_problem;

/**
 * @author：THIEM
 * @create:2021/12/31-14:52
 * 三叶的解法，用 num / i 代替 sqrt 库函数
 */
public class leetCode507_2 {
    public boolean checkPerfectNumber(int num) {
        if (num == 1) return false;
        int ans = 1;
        for (int i = 2; i <= num / i; i++) {
            if (num % i == 0) {
                ans += i;
                if (i * i != num) ans += num / i;
            }
        }
        return ans == num;
    }

}
