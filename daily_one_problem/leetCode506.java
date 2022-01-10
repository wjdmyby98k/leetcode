package daily_one_problem;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author：THIEM
 * @create:2021/12/2-11:05 "Gold Medal","Silver Medal","Bronze Medal"
 * Arrays.sort默认好像只提供int升序，其余的都是针对object对象
 * 1、int[]，double[]，char[]等基数据类型的数组，Arrays类之只是提供了默认的升序排列，没有提供相应的降序排列方法。
 * 2、要对基础类型的数组进行降序排序，需要将这些数组转化为对应的封装类数组，如Integer[]，Double[]，Character[]等，对这些类数组进行排序。
 */
public class leetCode506 {
    @Test
    public void Test() {
        int[] nums = new int[]{1, 4, 9, 7, 2, 5, 3, 8, 6};
        int[] clone = nums.clone();
        Arrays.sort(nums);
    }

    public String[] findRelativeRanks(int[] score) {
        int[] clone = score.clone();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        Arrays.sort(clone); //Arrays.sort默认好像只提供int升序，其余的都是针对object对象
        for (int i = clone.length - 1; i >= 0; i--) {
            hashMap.put(clone[i], clone.length - i);
        }
        String[] ans = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            int rank = hashMap.get(score[i]);
            if (rank == 1) {
                ans[i] = "Gold Medal";
            } else if (rank == 2) {
                ans[i] = "Silver Medal";
            } else if (rank == 3) {
                ans[i] = "Bronze Medal";
            } else {
                ans[i] = String.valueOf(hashMap.get(score[i]));
            }
        }
        return ans;
    }
}
