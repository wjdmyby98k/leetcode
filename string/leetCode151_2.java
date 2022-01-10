package string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author：THIEM
 * @create:2021/8/8-16:44
 * 补一个官方题解，直接用库函数（要了解）
 */
public class leetCode151_2 {
    class Solution {
        public String reverseWords(String s) {
            // 除去开头和末尾的空白字符
            s = s.trim();
            // 正则匹配连续的空白字符作为分隔符分割
            List<String> wordList = Arrays.asList(s.split("\\s+"));
            Collections.reverse(wordList);
            return String.join(" ", wordList);
        }
    }
}
