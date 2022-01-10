package daily_one_problem;

import java.util.Random;

/**
 * @author：THIEM
 * @create:2021/12/18-16:08
 * 评论区大神的
 */
public class leetCode470 {
    public int rand10() {
        int ans = rand2();
        for (int i = 0; i < 3; i++) {
            ans <<= 1;
            ans ^= rand2();
        }
        return (ans <= 10 && ans > 0) ? ans : rand10();
    }

    public int rand2() {
        int ans = rand7();
        return ans == 7 ? rand2() : ans % 2;
    }
    public int rand7(){
        Random random=new Random();
        return random.nextInt(7)+1;
    }
}
