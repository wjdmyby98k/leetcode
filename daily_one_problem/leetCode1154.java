package daily_one_problem;

/**
 * @author：THIEM
 * @create:2021/12/21-1:59
 */
public class leetCode1154 {
    public int dayOfYear(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));
        int ans = 0;
        int[] amount = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            amount[1]++;
        }
        for (int i = 0; i < month - 1; i++) {
            ans += amount[i];
        }
        ans += day;
        return ans;
    }
}
