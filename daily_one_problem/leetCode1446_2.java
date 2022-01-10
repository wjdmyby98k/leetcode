package daily_one_problem;

/**
 * @author：THIEM
 * @create:2021/12/1-17:05
 * 三叶的双指针解法，思路很好
 * 用一个左指针从0开始移动，每一轮循环开始让右指针等于左指针，如果左右相等，右指针递增，不相等就更新ans，同时更新左指针=右指针
 */
public class leetCode1446_2 {
    public int maxPower(String s) {
        int n = s.length(), ans = 1;
        for (int i = 0; i < n; ) {
            int j = i;
            while (j < n && s.charAt(j) == s.charAt(i)) j++;
            ans = Math.max(ans, j - i);
            i = j;
        }
        return ans;
    }

}
