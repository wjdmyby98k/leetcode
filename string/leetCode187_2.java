package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author：THIEM
 * @create:2021/12/27-15:31 字符串哈希
 * 一般选择P为131,131313
 * https://mp.weixin.qq.com/s?__biz=MzU4NDE3MTEyMA==&mid=2247489813&idx=1&sn=7f3bc18ca390d85b17655f7164d8e660&chksm=fd9cb20acaeb3b1cc78abf05d6fea6d093098998ce877f799ac478247604bd267fbee6fcd989&token=1342991619&lang=zh_CN#rd
 */
public class leetCode187_2 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int P = 13131;  // 其实这里13131不是质数，但是也过了？
        int n = s.length();
        int[] h = new int[n + 1];
        int[] p = new int[n + 1];
        p[0] = 1;
        for (int i = 0; i < n; i++) {
            h[i + 1] = h[i] * P + s.charAt(i);
            p[i + 1] = p[i] * P;
        }
        for (int i = 1; i <= n - 9; i++) {  // 难点就在于，下标的选择，从1开始！保证j取到n，再决定i的上界
            int j = i + 10 - 1;
            int cur = h[j] - h[i - 1] * p[j - i + 1];
            int cnt = hashMap.getOrDefault(cur, 0);
            if (cnt == 1) {
                String temp = s.substring(i - 1, i + 9);
                list.add(temp);
            }
            hashMap.put(cur, cnt + 1);
        }
        return list;
    }
}
