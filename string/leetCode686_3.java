package string;

import org.junit.Test;

/**
 * @author：THIEM
 * @create:2021/12/23-19:27 字符串哈希，新技巧！！！
 */
public class leetCode686_3 {
    @Test
    public void Test() {
        int a = Integer.MAX_VALUE;
        System.out.println(a);
        int b = 1;
        int hash = 131;
        for (int i = 0; i < 10; i++) {
            b = b * hash;
            System.out.println(b);
        }
        long aa = 38579489651L;
        long mod = aa % a;
        System.out.println(mod);
        int cc = 2147483647;
        int bb = cc + 1;
        System.out.println(bb);
    }

    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int ans = 0;
        while (sb.length() < b.length() && ++ans > 0) sb.append(a);
        sb.append(a);  // 上界
        int idx = BKDRHash(sb.toString(), b);
        if (idx == -1) return -1;
        return idx + b.length() > a.length() * ans ? ans + 1 : ans;
    }

    public int BKDRHash(String ss, String b) {
        int P = 131; //代表131进制的数
        int n = ss.length();
        int m = b.length();
        String str = ss + b;
        int len = str.length();
        int[] h = new int[len + 1];   // 构建hash表，+1是为了直接让下标n代表长度为n的哈希值！,有时候也写+10，但不懂为什么
        int[] p = new int[len + 1];    // 记录p的几次方，
        p[0] = 1;
        for (int i = 0; i < len; i++) {
            p[i + 1] = p[i] * P;
            h[i + 1] = h[i] * P + str.charAt(i);
        }
        int r = len, l = r - m + 1;
        int target = h[r] - h[l - 1] * p[r - l + 1];   // b的哈希值
        for (int i = 1; i <= n; i++) {
            int j = i + m - 1;
            int cur = h[j] - h[i - 1] * p[j - i + 1]; // 长度为m的字母的哈希值，等于h[r]-h[r-m] * p [m]
            if (cur == target) return i - 1; //这里减一才是真正的下标
        }
        return -1;   // 不存在就返回-1
    }
}
