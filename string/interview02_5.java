package string;

/**
 * @author：THIEM
 * @create:2021/8/6-9:13
 */
public class interview02_5 {
    public String replaceSpace(String s) {
        StringBuilder sb=new StringBuilder();
        char[] a=s.toCharArray();
        for(int i=0;i<s.length();i++){
            if(" ".equals(String.valueOf(a[i]))){
                sb.append("%20");
            }else {
                sb.append(a[i]);
            }
        }
        return sb.toString();
    }
}
