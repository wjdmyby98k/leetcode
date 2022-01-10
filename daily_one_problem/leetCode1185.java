package daily_one_problem;

/**
 * @author：THIEM
 * @create:2022/1/3-14:34 计算1971-2100年内任意一天是星期几，1970年最后一天是周四，注意ss数组第一天是星期天
 */
public class leetCode1185 {
    static String[] ss = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    static int[] nums = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public String dayOfTheWeek(int day, int month, int year) {
        int ans = 4;
        // 计算year贡献的天数
        for (int i = 1971; i < year; i++) {
            boolean isLeap = (i % 4 == 0 && i % 100 != 0) || i % 400 == 0;
            ans += isLeap ? 366 : 365;
        }
        // 计算month贡献的天数
        for (int i = 1; i < month; i++) {
            ans += nums[i - 1];
            if (i == 2 && ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)) {
                ans++;
            }
        }
        // 计算day贡献的天数
        ans += day;
        return ss[ans % 7];
    }
}
