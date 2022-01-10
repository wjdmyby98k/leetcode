package dynamic_programming;

/**
 * @author：THIEM
 * @create:2021/11/11-23:56
 * 双指针法
 * 首先确定回文串，就是找中心然后想两边扩散看是不是对称的就可以了。
 * 在遍历中心点的时候，要注意中心点有两种情况。
 * 一个元素可以作为中心点，两个元素也可以作为中心点。
 */
public class leetCode647_2 {
    public int countSubstrings(String s) {
        int result=0;
        for(int i=0;i<s.length();i++){
            result+=count(s,i,i,s.length()); // 一个中心点扩散
            result+=count(s,i,i+1,s.length()); // 两个中心点扩散
        }
        return result;
    }
    public int count(String s,int i,int j,int n){
        int res=0;
        while(i>=0 && j<n && s.charAt(i)==s.charAt(j)){
            res++;
            i--;
            j++;
        }
        return res;
    }
}
