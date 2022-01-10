package string;

/**
 * @author：THIEM
 * @create:2021/8/10-10:55
 *  用s+s做，用库函数
 *  如果s+s去掉头和尾还包含s，就说明有重复子串可以构成s
 */
public class leetCode459 {
    public boolean repeatedSubstringPattern(String s) {
        String str=s+s;
        return str.substring(1,str.length()-1).contains(s);
    }
}
