package dynamic_programming;

/**
 * @author：THIEM
 * @create:2021/11/12-0:04
 * 暴力解试试，129/130，最后一个测试案例比较极端，通过不了，暴力思路是对的！！！
 * StringBuffer没有重写object父类的equals方法，而String重写了，所以，StringBuffer的equals还是调用的==
 * 想要比较StringBuffer的内容，可以toSting以后再调用equals方法
 */
public class leetCode647_3 {
    public int countSubstrings(String s) {
        int res=0;
        // 遍历i-j区间，判断是不是回文
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(isValid(s,i,j)){
                    res++;
                }
            }
        }
        return res;
    }
    public boolean isValid(String s,int start,int end){
        StringBuffer sb1=new StringBuffer();
        StringBuffer sb2=new StringBuffer();
        for(int i=start;i<=end;i++){
            sb1.append(s.charAt(i));
        }
        for(int j=end;j>=start;j--){
            sb2.append(s.charAt(j));
        }
        return sb1.toString().equals(sb2.toString());  //调用String的equals方法
    }
}
