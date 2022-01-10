package hashTable;

/**
 * @author：THIEM
 * @create:2021/7/23-12:17
 * 循环100次没有到1，就return false
 */
public class leetCode202_2 {
    public boolean isHappy(int n){

        for(int i=0;i<100;i++){       //loop 100 times
            int ans=0;
            while(n>0){
                ans+=(n%10) * (n%10);
                n/=10;
            }
            n=ans;
            if(n==1) return true;

        }
        return false;
    }
}
