package daily_one_problem;

import java.util.Arrays;

/**
 * @author：THIEM
 * @create:2021/12/29-18:14
 * 力扣官方题解，这题有点模糊不清
 */
public class leetCode825 {
    public int numFriendRequests(int[] ages) {
        int n = ages.length;
        Arrays.sort(ages);
        int left = 0, right = 0, ans = 0;
        for (int age : ages) {
            if (age < 15) {
                continue;
            }
            while (ages[left] <= 0.5 * age + 7) {
                ++left;
            }
            while (right + 1 < n && ages[right + 1] <= age) {
                ++right;
            }
            ans += right - left;
        }
        return ans;
    }

}
