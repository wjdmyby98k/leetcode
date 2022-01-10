package string;

/**
 * @author：THIEM
 * @create:2021/8/5-20:56
 */
public class leetCode541 {
    public String reverseStr(String s, int k) {
        char[] chars=s.toCharArray();
        for(int i=0;i<chars.length;i+=2*k){
            int start=i;
            int end=Math.min(chars.length-1,k+start-1);
            while(start<end){
                chars[start]^=chars[end];
                chars[end]^=chars[start];
                chars[start]^=chars[end];
                start++;
                end--;
            }
        }
        return new String(chars);
    }
}

