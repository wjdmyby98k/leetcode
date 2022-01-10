package dynamic_programming;

/**
 * @author：THIEM
 * @create:2021/11/12-0:21
 * 暴力解法，不用StringBuffer，不用遍历两遍，304ms能过
 */
public class leetCode647_4 {
    public int countSubstrings(String s) {
        int res = 0;
        // 遍历i-j区间，判断是不是回文
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                res+=Count(s,i,j);
            }
        }
        return res;
    }
    public int Count(String s,int start,int end){
        int i=start;
        int j=end;
        while(i<=j && s.charAt(i)==s.charAt(j)){
            i++;
            j--;
        }
        return (i>j)?1:0;
    }
}
