package array;

/**
 * @author：THIEM
 * @create:2021/12/24-2:24
 */
public class leetCode844_2 {
    public boolean backspaceCompare(String s, String t) {
        int sSkipNum=0;
        int tSkipNum=0;
        int i=s.length()-1;
        int j=t.length()-1;
        while(true){
            // 找到第一个不需要消除的有效字母
            while (i>=0){
                if(s.charAt(i)=='#') sSkipNum++;
                else {
                    if(sSkipNum>0) sSkipNum--;
                    else break;
                }
                i--;
            }
            while (j>=0){
                if(t.charAt(j)=='#') tSkipNum++;
                else {
                    if(tSkipNum>0) tSkipNum--;
                    else break;
                }
                j--;
            }
            // 接下里判断一下i和j到底是循环完了，还是到了有效字符位置
            if(i<0 || j<0) break; // 代表s或者t有一个到头了
            if(s.charAt(i)!=t.charAt(j)) return false;  // 不相同直接false
            // 走到这一步，说明都是有效字符，都--进行下一个循环
            i--;
            j--;
        }
        if(i==-1 && j==-1) return true;  // 代表都走到头了
        return false;
    }
}
