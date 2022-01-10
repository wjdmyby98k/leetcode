package daily_one_problem;

/**
 * @author：THIEM
 * @create:2021/12/16-1:49
 * 三叶的解法，优雅！
 * 其实本质思路和我自己写的是一样的！！！！！！！！！！！！！！！
 */
public class leetCode400_2 {
    public int findNthDigit(int n) {
        int len = 1;
        while (len * 9 * Math.pow(10, len - 1) < n) {
            n -= len * 9 * Math.pow(10, len - 1);
            len++;
        }
        // 循环结束，len就代表n是几位数
        long s = (long) Math.pow(10, len - 1); // 求得len位的最小值
        s += n / len - 1; // n此时代表剩下的偏移量，s定位到目标数值的后一个，或者目标数字，具体要看mod的值
        n -= len * (n / len); // 此时n代表偏移量，作差之后相当于是取模，得到mod
        return n == 0 ? (int) (s % 10) : (int) ((s + 1) / Math.pow(10, len - n) % 10);
    }

}
