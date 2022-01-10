package daily_one_problem;

/**
 * @author：THIEM
 * @create:2021/11/25-14:22 信息熵，开阔视野就行，一只猪有5只状态，就是求5的多少次方，能大于buckets
 */
public class leetCode458 {
    public static void main(String[] args) {
        double a = Math.log(10);
        double b = Math.log(Math.E);
        System.out.println("a=" + a + "\nb=" + b);
//        a=2.302585092994046
//        b=1.0
    }

    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int k = minutesToTest / minutesToDie;
        return (int) Math.ceil(Math.log(buckets) / Math.log(k + 1));// java里面默认是e为底，结果等效于k+1为底，buckets为值的结果
    }
}
