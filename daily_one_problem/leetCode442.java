package daily_one_problem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author：THIEM
 * @create:2021/12/17-22:20
 * 原地哈希yyds！
 */
public class leetCode442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] != (i + 1) && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] != (i + 1)) {
                ans.add(nums[i]);
            }
        }
        return ans;
    }
}
