package daily_one_problem;

/**
 * @author：THIEM
 * @create:2022/1/8-15:22
 */
public class leetCode74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[m - 1][n - 1]) return false;
        int row = 0;
        int column = 0;
        while (row < m  && target > matrix[row][n-1]) {
            row++;
        }
        for (int j = 0; j < n; j++) {
            if (target == matrix[row][j]) return true;
            if (target < matrix[row][j]) return false;
        }
        return false;
    }
}
