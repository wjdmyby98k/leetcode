package daily_one_problem;

/**
 * @author：THIEMgvg
 * @create:2021/12/23-3:17
 */
public class leetCode925_2 {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        int m = name.length(), n = typed.length();
        while (i< m && j < n) {
            if (name.charAt(i) == typed.charAt(j)) {  // 相同则同时向后匹配
                i++; j++;
            }
            else {
                if (j == 0) return false; // 如果是第一位就不相同直接返回false
                // 判断边界为n-1,若为n会越界,例如name:"kikcxmvzi" typed:"kiikcxxmmvvzzz"
                while (j < n-1 && typed.charAt(j) == typed.charAt(j-1)) j++;
                if (name.charAt(i) == typed.charAt(j)) {  // j跨越重复项之后再次和name[i]匹配
                    i++; j++; // 相同则同时向后匹配
                }
                else return false;
            }
        }
        // 说明name没有匹配完
        if (i < m) return false;
        // 说明type没有匹配完
        while (j < n) {
            if (typed.charAt(j) == typed.charAt(j-1)) j++;
            else return false;
        }
        return true;
    }
}
