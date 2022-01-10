package daily_one_problem;

/**
 * @author：THIEM
 * @create:2021/12/1-16:55
 * 简单题重拳出击！
 */
public class leetCode1446 {
    public int maxPower(String s) {
        int maxLen = 1;
        int cnt = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                cnt++;
            } else {
                cnt = 1;
            }
            if (cnt > maxLen) {
                maxLen = cnt;
            }
        }
        return maxLen;
    }
}
