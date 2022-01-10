package daily_one_problem;

import java.util.HashMap;

/**
 * @author：THIEM
 * @create:2021/12/29-15:35
 * 利用等式关系 nums[a] + nums[b] + nums[c] = nums[d]nums[a]+nums[b]+nums[c]=nums[d]，
 * 可以调整枚举 c的顺序为「逆序」，每次 c 往左移动一个单位，d 的可取下标范围增加一个（即 c + 1位置)，
 * 使用数组代替哈希表对 nums[d]的个数进行统计，可使复杂度下降到 O(n^3)
 * 4 <= nums.length <= 50
 * 1 <= nums[i] <= 100
 */
public class leetCode1995_2 {
    public int countQuadruplets(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int[] count = new int[301];  //只需要301的空间，因为最大是100+100+100,对应下标300，三叶开的10100，习惯性多开吧
        for (int c = n - 2; c >= 2; c--) {
            count[nums[c + 1]]++;
            for (int a = 0; a < n; a++) {
                for (int b = a + 1; b < c; b++) {
                    ans += count[nums[a] + nums[b] + nums[c]];
                }
            }
        }
//        System.out.println(count[count.length-1]);
        return ans;
    }

    // 下面贴一个用map的哈希
    public int countQuadruplets1(int[] nums) {
        int ans = 0;
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int c = n - 2; c >= 2; c--) {
            map.put(nums[c + 1], map.getOrDefault(nums[c + 1], 0) + 1);
            for (int a = 0; a < n; a++) {
                for (int b = a + 1; b < c; b++) {
                    ans += map.getOrDefault(nums[a] + nums[b] + nums[c], 0);
                }
            }
        }
        return ans;
    }
}
