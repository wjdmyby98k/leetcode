package string;

import org.junit.Test;

/**
 * @author：THIEM
 * @create:2021/8/9-19:42
 */
public class leetCode28_KMP_Next {
    @Test
    public void Test(){
        char[] needle=new char[]{'a','a','a','a','b','a','a','a'};
        int len=8;
        int[] next=next(needle,len);

    }
    public  int[] next (char[] needle,int len) {
        //定义 next 数组
        int[] next = new int[len];
        // 初始化
        next[0] = -1;
        int k = -1;
        for (int i = 1; i < len; ++i) {
            //我们此时知道了 [0,i-1]的最长前后缀，但是k+1的指向的值和i不相同时，我们则需要回溯
            //因为 next[k]就时用来记录子串的最长公共前后缀的尾坐标（即长度-1）
            //就要找 k+1前一个元素在next数组里的值,即next[k+1]
            while (k != -1 && needle[k + 1] != needle[i]) {
                k = next[k];
            }
            // 相同情况，就是 k的下一位，和 i 相同时，此时我们已经知道 [0,i-1]的最长前后缀
            //然后 k - 1 又和 i 相同，最长前后缀加1，即可
            if (needle[k+1] == needle[i]) {
                ++k;
            }
            next[i] = k;

        }
        return next;
    }
}
