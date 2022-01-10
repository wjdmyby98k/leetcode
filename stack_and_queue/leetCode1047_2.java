package stack_and_queue;

/**
 * @author：THIEM
 * @create:2021/8/11-11:28
 * 用字符串作为栈，StringBuilder
 */
public class leetCode1047_2 {
    public String removeDuplicates(String s) {
        StringBuilder res =new StringBuilder();
        int top=-1;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            // 当 top > 0,即栈中有字符时，当前字符如果和栈中字符相等，弹出栈顶字符，同时 top--
            if (top >= 0 && res.charAt(top) == c) {
                res.deleteCharAt(top);
                top--;
                // 否则，将该字符 入栈，同时top++
            }else{
                res.append(c);
                top++;
            }
        }
        return res.toString();
    }
}
