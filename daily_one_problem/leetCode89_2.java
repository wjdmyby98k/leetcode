package daily_one_problem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author：THIEM
 * @create:2022/1/8-14:52 直接根据计算公式来
 */
public class leetCode89_2 {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {  // <<优先级  大于< 大于^
            ans.add(i >> 1 ^ i);
        }
        return ans;
    }
}
