package greedy_algorithm;

/**
 * @author：THIEM
 * @create:2021/10/4-20:22
 * 跳跃游戏II:每次在上次能跳到的范围（end）内选择一个能跳的最远的位置（也就是能跳到max_far位置的点）作为下次的起跳点 ！
 * 注意是非负整数的数组！！！
 * 给你一个     非负整数nums      你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 假设你总是可以到达数组的最后一个位置。
 */
public class leetCode45 {
    public int jump(int[] nums) {
        int step=0;  //步数
        int curDistance=0;  //当前能到的最远距离
        int nextDistance=0;   // 下一步能到的最远距离，就是当前能到的最远范围内，能到达的最远距离
        for (int i=0;i<nums.length;i++){
            nextDistance= Math.max(i+nums[i],nextDistance);
            if(i==curDistance){  //代表一步走完了
                if(curDistance<nums.length-1){
                    step++;
                }else {
                    break;
                }
                curDistance=nextDistance;
            }
        }
        return step;
    }
}
