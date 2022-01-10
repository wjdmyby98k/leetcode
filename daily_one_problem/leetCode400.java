package daily_one_problem;

/**
 * @author：THIEM
 * @create:2021/11/30-20:09
 * 1-9 9x1
 * 10-99 90x2
 * 100-999 900x3
 * 1000-9999 9000x4
 * 首先找到n属于几位数
 */
public class leetCode400 {
    public int findNthDigit(int n) {
        int ans=0;
        int a = n;
        int i = 0, j = 1;
        while (a-9 * (long) Math.pow(10, i) * j>0) { // 求出是几位数
            long temp = 9 * (long) Math.pow(10, i) * j;
            if (a > temp) {
                a -= temp;
                i++;
                j++;
            }
        }
        // 循环结束得到的j就是代表几位数
        long all_bit=0;
        for(int k=0;k<j-1;k++) {
            all_bit += 9 * Math.pow(10, k) * (k + 1);
        }
        long offset=n-all_bit;
        long m=offset/j;
        long mod=offset%j;
        long cur=(long)Math.pow(10,j-1);
        if(mod==0){  //mod为0，cur需要额外-1
            cur=cur+m-1;
            ans=(int)(cur%10);
        }else {
            cur=cur+m;
            ans=(int)(cur/ Math.pow(10,j-mod)%10);
        }
        return ans;
    }
}
