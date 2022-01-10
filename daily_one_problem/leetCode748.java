package daily_one_problem;

/**
 * @author：THIEM
 * @create:2021/12/10-15:12 简单题，学习两个函数，Character.isLetter(c)判断是否是字母
 * Character.toLowerCase(c)将字母小写
 */
public class leetCode748 {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] cnt = getCnt(licensePlate);
        String ans = null;
        for (String s : words) {
            int[] cur = getCnt(s);
            boolean flag = true;
            for (int i = 0; i < 26; i++) {
                if (cur[i] < cnt[i]) {
                    flag = false;
                }
            }
            if (flag && (ans == null || s.length() < ans.length())) {
                ans = s;
            }
        }
        return ans;
    }

    public int[] getCnt(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) { // 判断是字母
                cnt[Character.toLowerCase(c) - 'a']++; // 用小写替代，并收集
            }
        }
        return cnt;
    }
}
