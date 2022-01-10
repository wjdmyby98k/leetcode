package string;

/**
 * @author：THIEM
 * @create:2021/8/8-16:54
 */
public class interview02_58II {
    public String reverseLeftWords(String s, int n) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            sb.append(s.charAt(i));
        }
        reverseString(sb,0,n-1); //反转前n个
        reverseString(sb,n,sb.length()-1);//反转n到末尾的
//        reverseString(sb,0,sb.length()-1); //反转整个字符串
        sb.reverse();
        return new String(sb);//return toString()也可以
    }
    public void reverseString(StringBuilder sb,int start,int end){
        while (start<end){
            char c=sb.charAt(start);
            sb.setCharAt(start,sb.charAt(end));
            sb.setCharAt(end,c);
            start++;
            end--;
        }

    }
}
