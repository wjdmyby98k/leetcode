package daily_one_problem;

/**
 * @author：THIEM
 * @create:2021/11/26-19:24
 * 这题和第7题是一样的，事实上，也同样考虑溢出的问题，虽然这里直接过了
 */
public class leetCode9 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int oral=x;
        int reverse = 0;
        while (x != 0) {
            int digit = x % 10;
            x /= 10;
            reverse = reverse * 10 + digit;
        }
        return reverse == oral;
    }
}
