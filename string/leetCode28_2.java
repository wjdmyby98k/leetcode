package string;
/**
 * @author：THIEM
 * @create:2021/8/9-22:45
 * 用char优化
 */
public class leetCode28_2 {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0) return 0;
        if(haystack.length()==0) return -1;
        char[] s=haystack.toCharArray();
        char[] t=needle.toCharArray();
        int[] next=new int[needle.length()];
        getNext(t,next);
        int j=-1;
        for(int i=0;i<s.length;i++){
            while(j>=0 && s[i]!=t[j+1]){
                j=next[j];
            }
            if(s[i]==t[j+1]){
                j++;
            }
            if(j==t.length-1) return i-j;
        }
        return -1;
    }
    public void getNext(char[] t,int[] next){
        int j=-1;
        next[0]=-1;
        for(int i=1;i<t.length;i++){
            while(j>=0 && t[j+1]!=t[i]){
                j=next[j];
            }
            if(t[j+1]==t[i]){
                j++;
            }
            next[i]=j;
        }
    }
}
