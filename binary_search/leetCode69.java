package binary_search;

import org.junit.Test;

/**
 * @author：THIEM
 * @create:2022/1/9-15:11 int 最大值是2^31-1,long 最大值是2^63-1,int最大相乘，也不会溢出long！
 * (long) mid * mid 是 强转long以后再和int相乘，而（long）（mid * mid） 则是两个int相乘以后溢出了再转long，肯定是错的
 */
public class leetCode69 {
    @Test
    public void Test() {
        int ans = mySqrt1(2147395599);
        System.out.println(ans);
//        int mid = 2147483647;
//        int x = 2147395599;
//        long max = Long.MAX_VALUE;
//        long a = (long) mid * mid ;
//        boolean flag = (long) mid * mid <= x;
//        System.out.println(flag);
//        System.out.println(a);
//        System.out.println(max);
    }

    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public int mySqrt1(int x) {
        if (x == 0) return 0;
        if (x == 1 || x == 2 || x == 3) return 1;
        if (x == 4 || x == 5) return 2;
        long l = 0;
        long r = x;
        while (l < r) {
            // 但是这里可能会溢出，比如integer max，所以可以考虑全部使用long 最后再将结果转换成int
            long mid = l + (r - l + 1 >> 1);
            if ((long) mid * mid <= x) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return (int) l;
    }

    //或者解法2，把x规模先取一半，这样就不会溢出
    public int mySqrt2(int x) {
        if (x == 0) return 0;
        if (x == 1 || x == 2 || x == 3) return 1;
        if (x == 4 || x == 5) return 2;
        int l = 0;
        int r = x / 2;
        while (l < r) {
            int mid = l + (r - l + 1 >> 1);
            if ((long) mid * mid <= x) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
