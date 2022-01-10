package hashTable;

import java.util.Arrays;

/**
 * @author：THIEM
 * @create:2021/7/14-19:45
 * 总结一下，当我们遇到了要快速判断一个元素是否出现集合里的时候，就要考虑哈希法。
 *
 * 但是哈希法也是牺牲了空间换取了时间，因为我们要使用额外的数组，set或者是map来存放数据，才能实现快速的查找。
 *
 * 如果在做面试题目的时候遇到需要判断一个元素是否出现过的场景也应该第一时间想到哈希法！
 *
 * 用排序做，简单无脑，但是时间复杂度O（nlogn）,空间复杂度，java不允许改变字符串，所以得重新开辟新的空间
 */
public class leetCode242 {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;

        char[] s1=s.toCharArray();
        char[] t1=t.toCharArray();

        Arrays.sort(s1);
        Arrays.sort(t1);
        return Arrays.equals(s1,t1);
    }
}
