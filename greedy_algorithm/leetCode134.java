package greedy_algorithm;

/**
 * @author：THIEM
 * @create:2021/10/5-14:12
 * 暴力解法
 */
public class leetCode134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i=0;i<cost.length;i++){
            int rest=gas[i]-cost[i];  // 记录剩余油量
            int index=(i+1)%cost.length;   // index一方面控制下一轮的加油，一方面控制是否到达终点
            while(rest>0 && index!=i){  // 模拟以i为起点行驶一圈
                rest+=gas[index]-cost[index];
                index=(index+1)%cost.length;
            }
            // 如果以i为起点跑一圈，剩余油量>=0，返回该起始位置
            if(rest>=0 && index==i){
                return i;
            }
        }

        return -1;
    }
}
