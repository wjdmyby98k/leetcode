package daily_one_problem;

/**
 * @author：THIEM
 * @create:2021/12/14-15:03
 * 时间复杂度：O(\log n)O(logn)，即为递归的层数。
 *
 * 空间复杂度：O(\log n)O(logn)，即为递归的层数。这是由于递归的函数调用会使用栈空间。
 */
public class leetCode50 {
    public double myPow(double x, int n) {
        long N=n;
        return N>=0?quickMul(x,N):1.0/quickMul(x,-N);

    }
    public double quickMul(double x, long N){
        if(N==0) return 1.0;
        double y=quickMul(x,N/2);
        return N%2==0?y*y:y*y*x;
    }
}
