package string;

import org.junit.Test;

/**
 * @author：THIEM
 * @create:2021/8/8-14:54
 *
 * -------这题细节很多，把断点设置在循环处，可以快速看到每次循环结束的地方，方便调试
 *
 */
public class leetCode151 {
    @Test
    public void Test(){
        String s=new String("  Bob    Loves  Alice   ");
        System.out.println(reverseWords(s));
    }
    public String reverseWords(String s) {
        // System.out.println("ReverseWords.reverseWords2() called with: s = [" + s + "]");
        // 1.去除首尾以及中间多余空格
        StringBuilder sb = removeSpace(s);
        // 2.反转整个字符串
        reverseString(sb, 0, sb.length() - 1);
        // 3.反转各个单词
        reverseEachWord(sb);
        return sb.toString();
    }
    public StringBuilder removeSpace(String s){
        StringBuilder sb=new StringBuilder();
        //去除首尾的
        int start=0;
        int end =s.length()-1;
        while(s.charAt(start)==' ') start++;
        while(s.charAt(end)==' ') end--;
        //去除中间的
        while(start<=end){  //这里是小于等于
            char c=s.charAt(start);
            if(c!=' '||sb.charAt(sb.length()-1)!=' '){
                sb.append(c);
            }
            start++;
        }
        return sb;
    }
    public  void reverseString(StringBuilder sb, int start,int end){
        while(start<end){
            char temp=sb.charAt(start);
            sb.setCharAt(start,sb.charAt(end));
            sb.setCharAt(end,temp);
            start++;
            end--;
        }
    }
    public void reverseEachWord(StringBuilder sb ){
        int start=0;
        int end=0;
        int n=sb.length()-1;
        while(start<n){
            while(end<=n && sb.charAt(end)!=' '){
                end++;
            }
            reverseString(sb,start,end-1);
            start=end+1;
            end=start;
        }
    }
}
