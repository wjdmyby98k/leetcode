package string;

/**
 * @author：THIEM
 * @create:2021/8/5-19:40
 * 用位运算交换，位运算也可以交换字母
 */
public class leetCode344_2 {
    public void reverseString(char[] s) {
        int left=0;
        int right=s.length-1;
        while (left<right){
            s[left]^=s[right];
            s[right]^=s[left];
            s[left]^=s[right];
            left++;
            right--;
        }
    }
}
