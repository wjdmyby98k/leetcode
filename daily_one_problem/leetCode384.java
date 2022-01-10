package daily_one_problem;

import java.util.Random;

/**
 * @author：THIEM
 * @create:2021/11/22-16:38
 * 洗牌算法,按照三叶的思路做！
 * 对于下标 x而言，我们从 [x, n - 1] 中随机出一个位置与 x进行值交换
 * 当所有位置都进行这样的处理后，我们便得到了一个公平的洗牌方案。
 * 对于下标为 0位置，从 [0, n - 1]随机一个位置进行交换，共有 n种选择；
 * 下标为 1 的位置，从 [1, n - 1]随机一个位置进行交换，共有 n - 1种选择 ...
 * 最后就是n!
 */
public class leetCode384 {

}
class Solution {
    int[] nums; // 存放原数组
    int n;
    Random random=new Random();
    public Solution(int[] _nums) {
        nums=_nums;
        n=_nums.length;
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        int[] ans = nums.clone();
        for(int i=0;i<n;i++){
            swap(ans,i,i+random.nextInt(n-i));// 这个公式不理解就背住，或者画个区间表示一下
        }
        return ans;
    }
    public void swap(int[] arr,int i,int j){ // 交换i 和  j对应的数
        int c= arr[i];
        arr[i]=arr[j];
        arr[j]=c;
    }
}
