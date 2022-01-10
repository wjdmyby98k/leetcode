package daily_one_problem;

/**
 * @author：THIEM
 * @create:2022/1/5-1:51
 * 官方题解
 */
public class leetCode1576_2 {
    public String modifyString(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; ++i) {
            if (arr[i] == '?') {
                for (char ch = 'a'; ch <= 'c'; ++ch) {
                    // 关键就是这一步，同时注意到都是只用abc三个字符去填充，
                    // 在1~n-2的索引，就考虑两端，同时又包含了0和n-1,0只考虑右边，n-1只考虑左边
                    if ((i > 0 && arr[i - 1] == ch) || (i < n - 1 && arr[i + 1] == ch)) {
                        continue;
                    }
                    arr[i] = ch;
                    break;
                }
            }
        }
        return new String(arr);
    }

}
