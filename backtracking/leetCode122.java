package backtracking;

/**
 * @author：THIEM
 * @create:2021/9/26-18:16
 */
public class leetCode122 {
    public int maxProfit(int[] prices) {
        int result=0;
        for(int i=1;i<prices.length;i++){
            result+=Math.max((prices[i]-prices[i-1]),0);
        }
        return result;
    }
}
