package array.leetcode3;

public class leetcode3 {
    public static void main(String[] args) {
        int []tree = {1,2,3,1,2,2,2,1,1};
        Counter counter = new Counter();
        int ans= counter.totalFruit(tree);
        System.out.println(ans);
    }
}
