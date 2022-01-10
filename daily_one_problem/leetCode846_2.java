package daily_one_problem;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author：THIEM
 * @create:2021/12/30-14:18
 * 小堆+哈希
 */
public class leetCode846_2 {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b)->a-b);
        for (int i : hand) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            q.add(i);
        }
        while (!q.isEmpty()) {
            int t = q.poll();
            if (map.get(t) == 0) continue;
            for (int i = 0; i < groupSize; i++) {
                int cnt = map.getOrDefault(t + i, 0);
                if (cnt == 0) return false;
                map.put(t + i, cnt - 1);
            }
        }
        return true;
    }

}
