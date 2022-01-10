package daily_one_problem;

/**
 * @author：THIEM
 * @create:2021/11/26-18:06
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 */
public class leetCode7 {
    public static void main(String[] args) {
        int a = -123;
        int b = 123;
        System.out.println(a % 10);
        System.out.println(b % 10);
    }

    public int reverse(int x) {
        int ans=0;
        while(x!=0){
            if(ans<Integer.MIN_VALUE/10 || ans>Integer.MAX_VALUE/10){ //代表溢出了，这里有严格的数学推导，了解即可！！！
                return 0;
            }
            int digit=x%10; //取出最后一位，会包括符号
            x/=10; // x去除最后一位
            ans=ans*10+digit; //  推入最后一位
        }
        return ans;
    }

}
