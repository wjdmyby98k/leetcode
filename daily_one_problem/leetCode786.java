package daily_one_problem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author：THIEM
 * @create:2021/11/30-13:57 直接暴力
 */
public class leetCode786 {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        if (arr.length == 2) return arr;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                list.add(new int[]{arr[i], arr[j]});
            }
        }
        list.sort(((o1, o2) -> o1[0] * o2[1] - o1[1] * o2[0]));
        return list.get(k - 1);
    }
}
