package greedy_algorithm;

/**
 * @author：THIEM
 * @create:2021/9/27-15:19
 * 思路1：贪心
 * 查看每一步能到达的最远范围,不需要关心他是怎么到的，只需要判断能不能到！！！
 */
public class leetCode55 {
    public boolean canJump(int[] nums) {
        if(nums.length==1) return true;
        int cover=0;  //覆盖范围
        for(int i=0;i<=cover;i++){    //在覆盖范围内更新最大的覆盖范围
            cover= Math.max(i+nums[i],cover);
            if(cover>= nums.length-1){
                return true;
            }
        }
        return false;
    }
}
