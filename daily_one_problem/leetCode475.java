package daily_one_problem;

import java.util.Arrays;

/**
 * @author：THIEM
 * @create:2021/12/20-13:55
 */
public class leetCode475 {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int ans = 0;
        int temp;
        for (int i = 0; i < houses.length; i++) {
            temp = Math.abs(houses[i] - heaters[0]);
            for (int j = 0; j < heaters.length; j++) {
                int cur = Math.abs(houses[i] - heaters[j]);
//                System.out.println("temp="+temp+" cur="+cur);
                if (cur <= temp) {
                    temp = cur;
                }
            }
            ans = Math.max(ans, temp);
        }
        return ans;
    }
}
