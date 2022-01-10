package greedy_algorithm;

/**
 * @author：THIEM
 * @create:2021/9/27-15:19
 * 思路2
 * 从最后一个往前走，看前面那一步能不能到达当前这一步，如果可以，就看前一步的前一步，能不能到达前一步
 * 否则，就看前一步的前一步，能不能到达当前这一步
 */
public class leetCode55_2 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int last=n-1;
        for(int i=n-2;i>=0;i--){
            if((i+nums[i])>=last){
                last=i;
            }
        }
        if(last==0) return true;
        return false;
    }
}
