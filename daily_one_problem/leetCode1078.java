package daily_one_problem;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author：THIEM
 * @create:2021/12/27-16:06
 */
public class leetCode1078 {
    // 将list转换成数组
    @Test
    public void Test1() {
        List<String> list = new LinkedList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        String[] strings = new String[list.size()];
        list.toArray(strings);
        for (String s : strings) {
            System.out.println(s);
        }
        System.out.println(list);
        list.add("ddd");
        System.out.println(list);
    }

    // 数组转换成list，用aslist得到的list不支持add操作
    @Test
    public void Test2() {
        String[] strings = new String[]{"aaa", "bbb", "ccc"};
        List<String> list = new LinkedList<>();
        list = Arrays.asList(strings);
        System.out.println(list);
        list.add("ddd");
    }

    // 相当于是用构造器，将阉割版的list转换成成正常的list
    @Test
    public void Test3() {
        String[] strings = new String[]{"aaa", "bbb", "ccc"};
        List<String> list = new LinkedList<>(Arrays.asList(strings));
        System.out.println(list);
        list.add("ddd");
        System.out.println("----------------------");
        System.out.println(list);
    }

    // 用collections最高效
    @Test
    public void Test4() {
        String[] strings = new String[]{"aaa", "bbb", "ccc"};
        List<String> list = new LinkedList<>();
        Collections.addAll(list, strings);
        list.add("ddd");
        System.out.println(list);
    }

    public String[] findOcurrences(String text, String first, String second) {
        List<String> list = new LinkedList<>();
        List<String> ans = new LinkedList<>();
        int start = 0;
        int end = 0;
        StringBuilder sb = new StringBuilder();
        sb.append(text);
        sb.append(' ');
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == ' ') {
                end = i;
                String cur = sb.substring(start, end);
                list.add(cur);
                start = i + 1;
            }
        }
        System.out.println(list);
        for (int i = 0; i < list.size() - 1; i++) {
            String cur = list.get(i);
            String next = list.get(i + 1);
            if (first.equals(cur) && second.equals(next) && (i + 2) <= list.size() - 1) {
                ans.add(list.get(i + 2));
            }
        }
        return ans.toArray(new String[ans.size()]);
    }
}
