package string;

/**
 * @author：THIEM
 * @create:2021/8/8-17:26
 * 字符串切片
 */
public class interview02_58II_2 {
    public String reverseLeftWords(String s, int n) {

        return s.substring(n, s.length()) + s.substring(0, n);
    }
}
