package daily_one_problem;

import java.util.HashMap;

/**
 * @author：THIEM
 * @create:2021/11/26-19:52
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例
 * 官方题解可以囊括最后一个值
 */
public class leetCode13 {
    public static void main(String[] args) {
        leetCode13 leetCode13 = new leetCode13();
        int ans =leetCode13.romanToInt("IV"); //  这里测试用例不是重点，重点是string到底是放在常量池还是堆里面！后面看八股文
        System.out.println(ans);
    }
    public int romanToInt(String s) {
        HashMap<Character,Integer> hashMap = new HashMap<>();
        char[] chars=s.toCharArray();
        for(char c:chars){
            if(c=='I') hashMap.put('I',1);
            else if(c=='V') hashMap.put('V',5);
            else if(c=='X') hashMap.put('X',10);
            else if(c=='L') hashMap.put('L',50);
            else if(c=='C') hashMap.put('C',100);
            else if(c=='D') hashMap.put('D',500);
            else if(c=='M') hashMap.put('M',1000);
        }
        if(chars.length==1) return hashMap.get(chars[0]);
        int ans=0;
        for(int i=0;i<chars.length-1;i++){ // 这里最后一个字母没算进去，也可以直接<chars.length,然后在下面的if加上判断，i<length-1
            char cur=chars[i];
            char next=chars[i+1];
            if(hashMap.get(cur)<hashMap.get(next)){
                ans-=hashMap.get(cur);
            }else {
                ans+=hashMap.get(cur);
            }
        }
        ans+=hashMap.get(chars[chars.length-1]);   //最后一个字母肯定是加号
        return ans;
    }
}
