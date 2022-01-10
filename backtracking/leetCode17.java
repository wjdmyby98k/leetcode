package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author：THIEM
 * @create:2021/8/30-19:50
 * 也是一个组合问题，但是涉及到字母和数字的转换，了解一下思路
 */
public class leetCode17 {
    List<String> result = new ArrayList<>();
    StringBuffer path=new StringBuffer();
    String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0 || digits==null) return result;    //特殊情况判断
        backtracking(digits,0);
        return result;
    }
    public void backtracking(String digits,int num){ //num代表digits第几个数
        if(num==digits.length()){                  //回溯结束条件
            result.add(new String(path));
            return;
        }
        String str = numString[digits.charAt(num) - '0'];  //求对应数的字符数组

        for (int i = 0; i < str.length(); i++) {    //回溯套路
            path.append(str.charAt(i));
            backtracking(digits,num+1);
            path.deleteCharAt(path.length()-1);
        }
    }
}
