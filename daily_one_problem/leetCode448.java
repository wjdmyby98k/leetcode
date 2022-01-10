package daily_one_problem;

import java.util.LinkedList;
import java.util.List;

/**
 * @author：THIEM
 * @create:2021/12/17-21:46
 * 原地哈希yyds！
 * 进阶要求：o（n）时间复杂度，不用额外空间
 */
public class leetCode448 {
    public List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> ans = new LinkedList<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] != (i + 1) && nums[i] != nums[nums[i] - 1]) { //后面的条件是为了防止死循环！
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] != (i + 1)) {
                ans.add(i + 1);
            }
        }
        return ans;
    }


}
