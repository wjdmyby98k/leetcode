package daily_one_problem;

import org.junit.Test;

/**
 * @author：THIEM
 * @create:2021/11/23-22:05 击败百分之8
 */
public class leetCode6 {
    @Test
    public void Test() {
        String[] s = new String[2];
        System.out.println(s[0]);
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuffer sb = new StringBuffer();
        //向上截断的时候，一定要记得乘一个1.0，不然直接除是整数
        int block = (int) Math.ceil(1.0 * s.length() / (numRows + numRows - 2));
        int eachBlockNums = numRows + numRows - 2;
        int lastBlockNums = s.length() - eachBlockNums * (block - 1);
        String[][] ans = new String[numRows][(numRows - 1) * block];
        // 每个block是 numRows x （numRows-1）
        int cnt = 0;
        for (int b = 0, offset = 0; b < block; b++) {
            for (int i = 0; i < numRows; i++) {
                ans[i][0 + offset] = String.valueOf(s.charAt(cnt++));
                if (cnt == s.length()) break;
            }
            if (cnt == s.length()) break; //这里一定要加一个break，上面的循环如果break以后，要靠这个break跳出去，否则下面会越界
            for (int i = 1; i < numRows - 1; i++) {
                ans[numRows - 1 - i][i + offset] = String.valueOf(s.charAt(cnt++));
                if (cnt == s.length()) break;
            }
            offset += numRows - 1;
        }
        System.out.println(cnt);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                if (ans[i][j] != null) {
                    sb.append(ans[i][j]);
                }
            }
        }
        return sb.toString();
    }
}
