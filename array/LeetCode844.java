package array;

/**
 * @author：THIEM
 * @creat:2021/7/5-0:20
 */
public class LeetCode844 {
    //2
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            //退出while小循环，要么是遇见有效的字符break（大于0）要么是遍历完了没有有效字符（小于0）
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0) {
                if (S.charAt(i) != T.charAt(j)) {
                    return false;
                }
            } else {
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }


    //1
//    public boolean backspaceCompare(String s, String t) {
//
//        return extractString(s).equals(extractString(t));
//    }
//
//    public String extractString(String s) {
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (c != '#') {
//                sb.append(c);
//
//            } else {
//                if (sb.length() != 0) {
//                    sb.deleteCharAt(sb.length()-1);
//                }
//            }
//
//        }
//        return sb.toString();
//
//    }
}
