package greedy_algorithm;

/**
 * @author：THIEM
 * @create:2021/10/5-14:26：
 * 如果题目有解，该答案即为唯一答案。
 * 输入数组均为非空数组，且长度相同。
 * 输入数组中的元素均为非负数。
 * carl题解1：说了有解就是唯一答案！！！
 * 情况一：如果gas的总和小于cost总和，那么无论从哪里出发，一定是跑不了一圈的
 * 情况二：rest[i] = gas[i]-cost[i]为一天剩下的油，i从0开始计算累加到最后一站
 *          如果累加没有出现负数，说明从0出发，油就没有断过，那么0就是起点。
 * 情况三：如果累加的最小值是负数，汽车就要从非0节点出发，从后向前，看哪个节点能这个负数填平，能把这个负数填平的节点就是出发节点。
 */
public class leetCode134_2 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curSum=0;
        int min=Integer.MAX_VALUE;

        for (int i=0;i<cost.length;i++){
            curSum+=gas[i]-cost[i];
            if (curSum<min){  //这一步是为了找出最小值，看看有没有0
                min=curSum;
            }
        }
        if(curSum<0) return -1;
        if(min>=0) return 0;

        for (int i=cost.length-1;i<cost.length;i--){  // 这里为什么要是从末尾开始遍历呢？
            int rest=gas[i]-cost[i];
            min+=rest;
            if(min>=0){
                return i;
            }
        }
        return -1;
    }
}
