package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author：THIEM
 * @create:2021/12/27-15:21 滑动窗口+哈希,注意要考虑去重，但是不采用set，set太费空间
 */
public class leetCode187 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>();
        int n = s.length();
        Map<String, Integer> hashmap = new HashMap<>();
        for (int i = 0; i + 10 <= n; i++) {
            String cur = s.substring(i, i + 10);  //得到长度为10的子串
            int cnt = hashmap.getOrDefault(cur, 0);
            if (cnt == 1) {  //相当于去重了
                list.add(cur);
            }
            hashmap.put(cur, cnt + 1);
        }
        return list;
    }
}
