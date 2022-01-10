package backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author：THIEM
 * @create:2021/8/31-16:57
 * substring,start和end一样的时候，输出是空
 */
public class leetCode131 {
    @Test
    public void Test(){
        String s="aad";
        List<List<String>> ans=partition(s);
        System.out.println(ans);
    }
    List<List<String>> result= new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();
    public List<List<String>> partition(String s) {
        backtracking(s,0);
        return result;
    }
    public void backtracking(String s,int startIndex){
        if(startIndex>=s.length()){
            result.add(new ArrayList<>(path));   //这里一定是要new，不然都是同一个引用，最后path肯定是要回到空的！！！
            return;
        }
        for(int i=startIndex;i<s.length();i++){
            if(isPalindrome(s,startIndex,i)){
                String str=s.substring(startIndex,i+1);   //这里是起始位置，到结束位置，和c++不一样，c++是起始位置和个数
                path.add(str);
            }else {
                continue;
            }
            backtracking(s,i+1);
            path.removeLast();
        }
    }
    public boolean isPalindrome(String s, int startIndex, int end) {
        for (int i = startIndex, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}

