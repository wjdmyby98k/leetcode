package daily_one_problem;

/**
 * @author：THIEM
 * @create:2022/1/8-16:13 学习一下官方题解
 */
public class leetCode1629_2 {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char ans = keysPressed.charAt(0);
        int max = releaseTimes[0];
        for (int i = 1; i < keysPressed.length(); i++) {
            char cur = keysPressed.charAt(i);
            int time = releaseTimes[i] - releaseTimes[i - 1];
            if (time > max || (time == max && cur > ans)) {
                ans = cur;
                max = time;
            }
        }
        return ans;
    }
}
