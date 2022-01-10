package daily_one_problem;

/**
 * @author：THIEM
 * @create:2021/11/24-14:40
 */
public class leetCode6_2 {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;  // 每个循环的长度
        for (int i = 0; i < numRows; i++) { // 每一行写入
            for (int j = 0; j + i < n; j += cycleLen) { // 每一行写入的个数
                ret.append(s.charAt(j + i));  //每行写入一个，中间行按照下面的判断，额外写入一个
                if (i != 0 && i != numRows - 1 && (j + cycleLen - i) < n) {    // 最后一个条件就是为了防止越界
                    ret.append(s.charAt(j + cycleLen - i));
                }
            }
        }

        return ret.toString();
    }
}
