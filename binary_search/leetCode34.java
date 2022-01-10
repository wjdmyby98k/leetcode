package binary_search;

/**
 * @author：THIEM
 * @create:2022/1/9-16:48 找左右边界，存在的边界！
 * 左右边界其实就是对应了两种不同的写法，一个取上界，一个取下界
 * Ref：https://github.com/itcharge/LeetCode-Py/blob/main/Contents/01.Array/03.Array-Binary-Search/01.Array-Binary-Search.md
 */
public class leetCode34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        int leftBoarder = leftBoarder(nums, target);
        int rightBoarder = rightBoarder(nums, target);
        if (leftBoarder == -2 || rightBoarder == -2) return new int[]{-1, -1};
        return new int[]{leftBoarder, rightBoarder};
    }

    //先找右边界
    public int rightBoarder(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return nums[l] == target ? l : -2;
    }

    //再找左边界
    public int leftBoarder(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l] == target ? l : -2;
    }
}
