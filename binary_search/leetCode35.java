package binary_search;

/**
 * @author：THIEM
 * @create:2022/1/9-16:32
 */
public class leetCode35 {
    public int searchInsert(int[] nums, int target) {
        if (target < nums[0]) return 0;
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (nums[mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return nums[l] == target ? l : l + 1;
    }
}
