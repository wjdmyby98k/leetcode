package daily_one_problem;

/**
 * @author：THIEM
 * @create:2022/1/7-10:22
 * 括号的最大深度
 */
public class leetCode1614 {
    public int maxDepth(String s) {
        int cnt = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                cnt++;
                max = Math.max(cnt, max);
            } else if (s.charAt(i) == ')') cnt--;

        }
        return max;
    }
}

