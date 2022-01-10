package daily_one_problem;

/**
 * @author：THIEM
 * @create:2021/11/26-21:19
 */
public class leetCode14 {
    public String longestCommonPrefix(String[] strs) {
        StringBuffer sb = new StringBuffer();
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) { // 找出最短的字符串长度
            if (str.length() < minLen) {
                minLen = str.length();
            }
        }
        boolean flag=true;
        for (int i = 0; i < minLen; i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != strs[0].charAt(i)) {
                    flag=false;
                    break;
                }
            }
            if(!flag) break;
            sb.append(strs[0].charAt(i)); // 这里是0，一不小心就越界了
        }
        return sb.toString();
    }
}
