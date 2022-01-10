package daily_one_problem;

/**
 * @author：THIEM
 * @create:2021/12/17-20:21
 * // 满足在指定范围内、并且没有放在正确的位置上，才交换,同时避免重复交换
 */
public class leetCode41 {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1); //封装成函数，不然可能会出错！！！
                // 即nums会变化，除非向下面这样写，最好的方式就是封装成函数
//                int temp=nums[nums[i]-1];
//                nums[nums[i]-1]=nums[i];
//                nums[i]=temp;
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return len + 1;
    }

    public void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
