package array;//滑动窗口求子序列，只能有两种不同的数
//但是窗口只能求长度，不能求这个长度最终的起点和终点，但是在遍历过程中可以找到
import java.util.HashMap;

public class LeetCode904{
    public static void main(String[] args) {
        int []tree = {1,2,3,1,2,2,2,1,1,4,5,6,7,8};
        int ans= totalFruit(tree);
        System.out.println(ans);
    }
    public static int totalFruit(int[] tree) {
        int ans = 0;
        int i = 0; //i是滑动窗口起点
        Counter count = new Counter();
        for (int j = 0; j < tree.length; ++j) {    //j是滑动窗口终点
            count.add(tree[j],1);               //count继承hashmap，就干两件事，get查值，add加键值对，每次加一个键值对
            while (count.size() >= 3) {             //hashmap超过三个值，就考虑有没有三个不同的值
                count.add(tree[i], -1);           //把第一个元素对应的值设置-1，如果为0，就把这个键值对删除
                if (count.get(tree[i]) == 0)
                    count.remove(tree[i]);
                i++;                                  //删除以后滑动窗口起点加1
            }
            System.out.println(count+" j="+j+" i="+i);

            ans = Math.max(ans, j - i + 1);   //最后的长度就是i-j这一段

        }

        return ans;
    }
}
class Counter extends HashMap<Integer, Integer> {
    public int get(int k) {
        return containsKey(k) ? super.get(k) : 0;
    }

    public void add(int k, int v) {
        put(k, get(k) + v);
    }
}







