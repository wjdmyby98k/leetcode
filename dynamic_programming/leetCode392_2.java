package dynamic_programming;

/**
 * @author：THIEM
 * @create:2021/11/11-15:56
 * 双指针！！！思路值得学习，这样是最快的
 */
public class leetCode392_2 {
    public boolean isSubsequence(String s, String t) {
        int i=0; //记录遍历s的位置
        if(s.length()==0) return true; //考虑特殊情况
        for(int j=0;j<t.length();j++){
            if(s.charAt(i)==t.charAt(j)){
                i++;
                if(i==s.length()){
                    return true;
                }
            }
        }
        return false;
    }
}
