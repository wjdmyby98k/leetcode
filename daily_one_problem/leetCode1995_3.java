package daily_one_problem;

import java.util.HashMap;

/**
 * @author：THIEM
 * @create:2021/12/29-16:02
 * 更进一步，根据等式关系进行移项可得：nums[a] + nums[b] = nums[d] - nums[c]，其中各下标满足 a < b < c < d
 * 我们可在「逆序」枚举 b 时，将新产生的 c（即 b + 1位置）所能产生的新 nums[d] - nums[c]的值存入哈希表
 * （即 从 [b + 2, n)范围内枚举 d），最后通过枚举 a来统计答案。
 * 一些细节：由于 nums[d] - nums[c]可能为负，在使用数组代替哈希表时，可利用 1 <= nums[i] <= 100 做一个值偏移。
 * 可使复杂度下降到 O(n^2)
 * b倒序遍历，d同时顺序遍历，可以把nums[d]-nums[c]的所有情况确定。习惯这种写法！
 */
public class leetCode1995_3 {
    public int countQuadruplets(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int[] count = new int[401];  // 多开了100空间
        for (int b = n - 3; b >= 1; b--) {
            for (int d = b + 2; d < n; d++) {
                count[nums[d] - nums[b + 1] + 100]++; //加100偏移量，因为可能是负的，建议多开
            }
            for (int a = 0; a < b; a++) {
                ans += count[nums[a] + nums[b] + 100];
            }
        }
        return ans;
    }

    // 同理下面贴一个用map的哈希
    public int countQuadruplets1(int[] nums) {
        int ans = 0;
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int b = n - 3; b >= 1; b--) {
            for (int d = b + 2; d < n; d++) {
                map.put(nums[d] - nums[b + 1], map.getOrDefault(nums[d] - nums[b + 1], 0) + 1);
            }
            for (int a = 0; a < b; a++) {
                ans += map.getOrDefault(nums[a] + nums[b], 0);
            }
        }
        return ans;
    }
}
