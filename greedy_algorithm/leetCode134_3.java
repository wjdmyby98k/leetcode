package greedy_algorithm;

/**
 * @author：THIEM
 * @create:2021/10/5-20:02
 * 贪心思想：i从0开始累加rest[i]，和记为curSum，一旦curSum小于零，说明[0, i]区间都不能作为起始位置
 * 起始位置从i+1算起，再从0计算curSum。
 */
public class leetCode134_3 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curSum = 0;
        int totalSum = 0;
        int start = 0;
        for (int i=0;i<cost.length;i++){
            curSum+=gas[i]-cost[i];
            totalSum+=gas[i]-cost[i];
            if(curSum<0){
                start=i+1;
                curSum=0;
            }
        }
        if(totalSum<0){
            return -1;
        }
        return start;
    }
}
