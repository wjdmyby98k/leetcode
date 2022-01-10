package array;

/**
 * @author：THIEM
 * @creat:2021/7/4-14:46
 * 纯数学解法
 */
public class LeetCode343 {
    public static int IntegerBreak(int n){
        if(n==2){
            return 1;
        }
        if(n==3){
            return 2;
        }
        if(n==4){
            return 4;
        }
        int result=1;
        while(n>4){
            n-=3;
            result*=3;
        }
        result*=n;
        return result;
    }
}
