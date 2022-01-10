package string;

/**
 * @author：THIEM
 * @create:2021/8/10-11:49
 * 暴力枚举，画图方便理解
 */
public class leetCode459_3 {
    public boolean repeatedSubstringPattern(String s) {
        for(int i=1;i*2<=s.length();i++){  //i代表重复串的长度，最小为1
            if(s.length()%i==0){//除尽代表可能是重复子串
                boolean flag=true;
                for(int j=i;j<s.length();j++){
                    // j代表后面重复串的第j个，从重复子串的长度i开始
                    // j-i代表第一个重复串的第j-i个，从第一个重复子串的第一个开始，也就是0

                    if(s.charAt(j)!=s.charAt(j-i)){
                        flag=false;
                        break;       //加个break可以减少运行时间！！！！！！！不加也能运行
                    }
                }
                if(flag==true){
                    return true;
                }
            }
        }
        return false;
    }
}
