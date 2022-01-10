package daily_one_problem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author：THIEM
 * @create:2021/12/27-18:51
 * 简洁版，方法1相当于自己手写了一个split
 */
public class leetCode1078_2 {
    public String[] findOcurrences(String text, String a, String b) {
        String[] ss = text.split(" ");// 这里源码是用的正则表达式实现的
        int n = ss.length;
        List<String> list = new ArrayList<>();
        for (int i = 0; i + 2 < n; i++) {  // 要习惯i+2这种类似的写法！
            if (ss[i].equals(a) && ss[i + 1].equals(b)) list.add(ss[i + 2]);
        }
        return list.toArray(new String[list.size()]);
    }

}
