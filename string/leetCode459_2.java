package string;

/**
 * @author：THIEM
 * @create:2021/8/10-10:56
 * 用KMP做
 *
 * 最长相等前后缀的长度为：next[len - 1] + 1。
 * 数组长度为：len。
 * 如果len % (len - (next[len - 1] + 1)) == 0 ，
 * 则说明 (数组长度-最长相等前后缀的长度) 正好可以被 数组的长度整除，说明有该字符串有重复的子字符串。
 * 数组长度减去最长相同前后缀的长度相当于是第一个周期的长度，也就是一个周期的长度，
 * 如果这个周期可以被整除，就说明整个数组就是这个周期的循环。
 */
public class leetCode459_2 {
    public boolean repeatedSubstringPattern(String s) {
        if(s.length()==0 || s.length()==1) return false;  //01特殊情况
        int[] next=new int[s.length()];
        getNext(s,next);
        int i=next[next.length-1]+1;  //最长的相等前后缀长度，肯定是大于s/2的
        //这里加一个判断，最长相等前后缀长度要大于s一半
        if (i>=s.length()/2 && s.length()%(s.length()-i)==0) {
            return true;
        }
        return false;
    }
    public void getNext(String s,int[] next){
        int j=-1;
        next[0]=-1;
        for(int i=1;i<s.length();i++){
            while(j>=0 && s.charAt(j+1)!=s.charAt(i)){
                j=next[j];
            }
            if(s.charAt(j+1)==s.charAt(i)){
                j++;
            }
            next[i]=j;
        }
    }
}
