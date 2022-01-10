package greedy_algorithm;

/**
 * @author：THIEM
 * @create:2021/10/5-21:05
 * hard,直接cv
 * 一次是从左到右遍历，只比较右边孩子评分比左边大的情况。
 * 一次是从右到左遍历，只比较左边孩子评分比右边大的情况。
 */
public class leetCode135 {
    public int candy(int[] ratings) {
        int[] candy = new int[ratings.length];
        for (int i = 0; i < candy.length; i++) {  //初始化都为1
            candy[i] = 1;
        }

        for (int i = 1; i < ratings.length; i++) {  //从前往后
            if (ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            }
        }

        for (int i = ratings.length - 2; i >= 0; i--) { // 从后往前
            if (ratings[i] > ratings[i + 1]) {
                candy[i] = Math.max(candy[i],candy[i + 1] + 1);
            }
        }

        int count = 0;   // 统计结果
        for (int i = 0; i < candy.length; i++) {
            count += candy[i];
        }

        return count;
    }
}
