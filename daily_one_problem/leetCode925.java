package daily_one_problem;

import org.junit.Test;

/**
 * @author：THIEM
 * @create:2021/12/22-21:26 坑，除了考虑顺序以外，还要考虑不能多字母
 */
public class leetCode925 {
    @Test
    public void Test() {
        String name = "alex";
        String typed = "aaleexa";
        boolean ans = isLongPressedName(name, typed);
        System.out.println(ans);
    }

    public boolean isLongPressedName(String name, String typed) {
        char[] chars1 = name.toCharArray();
        char[] chars2 = typed.toCharArray();
        int len1 = chars1.length;
        int len2 = chars2.length;
        if (len2 < len1) return false;
        if (chars1[0] != chars2[0]) {
            return false;
        }
        int j = 1;
        int i = 1;
        for (; j < len2 && i < len1; j++) {
            if (chars2[j] != chars1[i]) {
                if (chars2[j - 1] == chars2[j]) {
                    continue;
                } else {
                    return false;
                }
            } else {
                i++;
            }
        }
        // 循环结束以后，判断到底是哪一个到末尾了
        if (i == len1) {
            j--;
            int k = j;
            for (; j < len2; j++) {
                if (chars2[j] != chars2[k]) {
                    return false;
                }
            }
        }else if(j==len2){
            if(i<=len1){
                return false;
            }
        }
        return true;
    }
}
