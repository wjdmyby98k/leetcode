package daily_one_problem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author：THIEM
 * @create:2021/12/30-13:46 排序+哈希
 * 注意map的get操作，没有的时候，是返回的null
 * 这题和1296类似
 */
public class leetCode846 {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Arrays.sort(hand);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : hand) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        // 遍历每个元素，从最小的开始
        for (int k : hand) {
            // 如果当前这个元素取出来是0，说明已经用过了
            if (map.get(k) == 0) continue;
            for (int j = 0; j < groupSize; j++) {
                // 没有用过的话，就要保证以后连续groupSize个元素都存在，有一个不存在就false，同时更新map里面的值
                int cnt = map.getOrDefault(k + j, 0);
                if (cnt == 0) return false;
                map.put(k + j, cnt - 1);
            }
        }
        return true;
    }
}
