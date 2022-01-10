package daily_one_problem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author：THIEM
 * @create:2022/1/8-14:46 三叶的解法看不懂，参考评论区大神，镜像反射
 */
public class leetCode89 {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = ans.size() - 1; j >= 0; j--) { // 倒序遍历
                ans.add(head + ans.get(j));   // 复制并在首位加1，首位加1，相当于加head，同时head不断左移
            }
            head <<= 1;
        }
        return ans;
    }
}
