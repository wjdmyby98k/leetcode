package daily_one_problem;

/**
 * @author：THIEM
 * @create:2021/11/26-19:29
 * 负数全部false，末尾有0全部false（除非就是0），再反转一半，当当前的数字<=反转后的数字，代表反转了一半了！
 */
public class leetCode9_2 {
    public static void main(String[] args) {
        int a =100;
        int b=1;
        if(a%10==0){
            b=0;
        }
        System.out.println("a="+a+" b="+b);
    }
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        if(x%10==0 && x!=0) return false;
        int rev=0;
        while(x>rev){
            int digit=x%10;
            x/=10;
            rev=rev*10+digit;
        }
        return x==rev || x==rev/10;
    }
}
