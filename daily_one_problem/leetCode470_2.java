package daily_one_problem;

import org.junit.Test;

import java.util.Random;

/**
 * @author：THIEM
 * @create:2021/12/18-16:10
 * 用进制去理解，k进制，每位是0-k-1；
 */
public class leetCode470_2 {
    @Test
    public void Test(){
        int i = 1;
        int ans=++i%10+1;
        System.out.println(ans);
    }
    public int rand10() {
        while(true){
            int ans = 7*(rand7()-1)+rand7()-1;  //得到0-48的均匀分布
            if(ans>=1 && ans <=40){
                return ans%10+1;
            }
        }
    }
    public int rand7(){
        Random random=new Random();
        return random.nextInt(7)+1;
    }
}
