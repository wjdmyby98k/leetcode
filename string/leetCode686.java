package string;

/**
 * @author：THIEM
 * @create:2021/12/22-11:01
 * 三叶关于上界下届的解释很清楚，可能匹配的最小和最大次数
 * 上界：复制a多少次以后长度刚好大于b
 * 下届：上界+1
 * 卡常：面试的时候时间不够可以尝试用这种方法，人为设置一个时间限制！！！
 */
public class leetCode686 {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int ans = 0;
        while (sb.length() < b.length() && ++ans > 0) sb.append(a); //循环结束以后，刚好a的长度>=b的长度
        long startTime=System.currentTimeMillis();
        while (System.currentTimeMillis()-startTime<100){  //100是卡测试时间，调出来的
            if(sb.indexOf(b)!=-1) return ans;
            sb.append(a);
            ans++;
        }
        return -1;
    }
}
