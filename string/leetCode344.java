package string;

/**
 * @author：THIEM
 * @create:2021/8/5-19:35
 */
public class leetCode344 {
    public void reverseString(char[] s) {
        int left=0;
        int right=s.length-1;
        char temp;
        while(left<right){
            temp=s[left];
            s[left]=s[right];
            s[right]=temp;
            left++;
            right--;
        }
    }
}
