package daily_one_problem;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author：THIEM
 * @create:2022/1/6-13:43
 * 三叶解法，用双指针模拟
 */
public class leetCode71_2 {
    public String simplifyPath(String path) {
        Deque<String> deque = new ArrayDeque<>();
        int n = path.length();
        for (int i = 1; i < n; i++) {
            if (path.charAt(i) == '/') continue;   // 找到下一个不是"/"的位置
            int j = i + 1;   // j指向下一个位置，双指针！
            while (j < n && path.charAt(j) != '/') j++; // 直到j指向的位置是"/"
            String temp = path.substring(i, j);   // 左闭右开，[i,j)
            if (temp.equals("..")) {     //..的时候，栈内有元素才删
                if (!deque.isEmpty()) {
                    deque.pollLast();
                }
            } else if (!(temp.equals("."))) { // .的时候就continue，这里省略了，不是.的时候就进栈
                deque.addLast(temp);
            }
            i = j; //j是指向"/"的，令i=j开始下一轮循环
        }
        StringBuilder ans = new StringBuilder();
        while (!deque.isEmpty()) {  // 还原栈内的路径
            ans.append("/");
            ans.append(deque.pollFirst());
        }
        return ans.length() == 0 ? "/" : ans.toString();  // 栈为空就直接返回"/",否则返回ans.toString()
    }
}
