package string;

import org.junit.Test;

/**
 * @author：THIEM
 * @create:2021/12/22-11:24 知道了上下界的概念，其实就不用卡常了，直接试上界和下届就行了！
 */
public class leetCode686_2 {
    @Test
    public void Test() {
        String a = "abcd";
        String b = "wqeqeqwe";
        StringBuilder sb = new StringBuilder();
        int ans = 0;
        while (sb.length() < b.length() && ++ans > 0) sb.append(a);
        sb.append(a);
        System.out.println(ans + "" + sb.toString());
    }

    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int ans = 0;
        while (sb.length() < b.length() && ++ans > 0) sb.append(a); // 结束时候sb的长度>=b的长度
        sb.append(a);  // 再加个a就一定大于了，此时为上界
        int idx = sb.indexOf(b);
        if (idx == -1) return -1;  // 如果此时不能匹配，那就不能匹配
        // 这里我有个误区，觉得应该是a.len * ans -1,可以这样理解，idx就代表前面几个字母，左边是字母长度，右边也是字母长度，
        // 判断要么都比索引，要么都比长度!!!
        return idx + b.length() > a.length() * ans ? ans + 1 : ans;
    }
}
