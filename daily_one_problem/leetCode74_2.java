package daily_one_problem;

/**
 * @author：THIEM
 * @create:2022/1/9-14:30
 * 感觉控制第一个if里面是>=还是<=就能找到对应的左右边界
 */
public class leetCode74_2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int l, r;
        l = 0;
        r = m - 1;
        // 定位行，找到最后一个<=target的行
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (matrix[mid][0] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        int row = r;
        if (matrix[row][0] == target) return true;
        if (matrix[row][0] > target) return false;
        l = 0;
        r = n - 1;
        // 对当前这一行，找最后一个<=target的位置
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (matrix[row][mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        int column = r;
        return matrix[row][column] == target;
    }
}


