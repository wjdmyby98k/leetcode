package daily_one_problem;

import com.sun.deploy.util.StringUtils;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author：THIEM
 * @create:2022/1/6-1:28
 */
public class leetCode71 {
    @Test
    public void Test() {
        String path = "/home//foo/";
        //但是貌似力扣不支持这个库
        String[] result = StringUtils.splitString(path, "/");
        System.out.println(result.length);
        for (String s : result) {
            System.out.println(s);
        }
    }

    public String simplifyPath(String path) {
        // 既然是想用栈，就只考虑push和pop，都是头插和头删
        Deque<String> deque = new LinkedList<>();
        String[] result = path.split("/");
        for (String s : result) {
            if (s.equals("..")) {
                if (deque.size() != 0) {
                    deque.pop();
                }
            } else if (s.equals(".") || s.equals("")) {
                continue;
            } else {
                deque.push(s);
            }
        }
        if (deque.size() == 0) return "/";
        StringBuilder ans = new StringBuilder();
        while (deque.size() != 0) {
            ans.append("/");
            ans.append(deque.pollLast());
        }
        return ans.toString();
    }
}
