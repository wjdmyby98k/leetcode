package daily_one_problem;

import org.junit.Test;

/**
 * @author：THIEM
 * @create:2022/1/5-0:20
 * 题目只要求不是连续重复即可！
 * 开始看错了题目，后来想到只考虑中间的，最后再考虑两端！
 */
public class leetCode1576 {
    @Test
    public void Test() {
        char c = 'a';
        c++;
        System.out.println(c);
    }

    public String modifyString(String s) {
        char[] chars = s.toCharArray();
        int index = 0;
        for (int i = 1; i < chars.length - 1; i++) {
            if (chars[i] == '?') {
                chars[i] = 'a';
                while (chars[i] == chars[i - 1] || chars[i] == chars[i + 1]) {
                    chars[i]++;
                }
            }
        }
        if (chars[0] == '?') {
            chars[0] = 'a';
            while (chars.length != 1 && chars[0] == chars[1]) {
                chars[0]++;
            }
        }
        if (chars[chars.length - 1] == '?') {
            chars[chars.length - 1] = 'a';
            while (chars.length != 1 && chars[chars.length - 1] == chars[chars.length - 2]) {
                chars[chars.length - 1]++;
            }
        }
        String ans = new String(chars);
        return ans;
    }
}
