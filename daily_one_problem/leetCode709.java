package daily_one_problem;

/**
 * @author：THIEM
 * @create:2021/12/14-16:38 s 由 ASCII 字符集中的可打印字符组成
 * <p>
 * 位运算的技巧，A-Z 65-90  a-z 97-122
 * A是0100 0001  a是0110 0001  ，大写变小写，把第六位置1，小写变大写，把第六位置为0，大写变小写，小写变大写，
 * 大写变小写、小写变大写 : 字符 ^= 32;
 * <p>
 * 大写变小写、小写变小写 : 字符 |= 32; 0010 0000
 * <p>
 * 小写变大写、大写变大写 : 字符 &= -33;负数是补码，1101 1111
 */
public class leetCode709 {
    public String toLowerCase1(String s) {
        return s.toLowerCase();
    }

    public String toLowerCase(String s) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 65 && c <= 90) {  //只把大写字母小写，其余不是字母的不变
                c |= 32;
            }
            ans.append(c);
        }
        return ans.toString();
    }
}
