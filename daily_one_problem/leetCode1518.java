package daily_one_problem;

/**
 * @author：THIEM
 * @create:2021/12/17-14:13
 */
public class leetCode1518 {
    public int numWaterBottles1(int numBottles, int numExchange) {
        int m = (numBottles / numExchange);
        int n = (numBottles % numExchange);
        int ans = numBottles + m;
        while ((m + n) >= numExchange) {
            m = m + n;
            n = m % numExchange; //先求余再除，否则顺序不对，m就已经变化了
            m /= numExchange;
            ans += m;
        }
        return ans;
    }

    // 美化一下写法
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;
        while (numBottles >= numExchange) {
            int a = numBottles / numExchange;
            int b = numBottles % numExchange;
            ans += a;
            numBottles = a + b;
        }
        return ans;
    }
}
