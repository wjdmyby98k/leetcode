package stack_and_queue;

/**
 * @author：THIEM
 * @create:2021/8/11-11:38
 * 用双指针做，这样做是最快的
 */
public class leetCode1047_3 {
    public String removeDuplicates(String s) {
        int slow=0;
        int fast=0;
        char[] chars=s.toCharArray();
        for(;fast<s.length();fast++){
            chars[slow]=chars[fast];
            if(slow>0 && chars[slow]==chars[slow-1]){
                slow--;
            }else {
                slow++;
            }

        }
        return new String(chars,0,slow);  //注意这里offset是起始索引，slow是长度，如果从0开始的话，长度和末尾索引等价
    }
}
