package daily_one_problem;

import java.util.Arrays;

/**
 * @author：THIEM
 * @create:2021/12/20-19:45 用二分法的思想，就是找每个房子，在供暖器数组里面的左边界和右边界！
 */
public class leetCode475_2 {
    //    @Test
//    public void Test(){
//        int[] heaters=new int[]{1,2,3,4};
//        int[] houses=new int[]{1,4};
//        for (int house : houses){
//            int a = binarySearch(heaters,house);
//            System.out.println(a);
//        }
//    }
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int ans = 0;
        for (int house : houses) {
            int i = binarySearch(heaters, house);
            int j = i + 1;
            int leftDistance = i == -1 ? Integer.MAX_VALUE : house - heaters[i];
            int rightDistance = i == (heaters.length - 1) ? Integer.MAX_VALUE : heaters[j] - house;
            int curDistance = Math.min(leftDistance, rightDistance);
            ans = Math.max(curDistance, ans);
        }
        return ans;
    }

    // 如果存在，就返回他的右边界（含），如果不存在，就返回应该插入的位置前一个
    public int binarySearch(int[] heaters, int house) {
        int l = 0;
        int r = heaters.length - 1;
        if (heaters[0] > house) {
            return -1;
        }
        while (l <= r) {
            int middle = l + ((r - l) >> 1);  //这里没打括号，debug半天找不到错误！！！
            if (heaters[middle] > house) {
                r = middle - 1;
            } else if (heaters[middle] == house) {
                l = middle + 1;
            } else if (heaters[middle] < house) {
                l = middle + 1;
            }
        }

        return l - 1;
    }
}
