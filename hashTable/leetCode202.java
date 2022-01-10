package hashTable;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author：THIEM
 * @create:2021/7/23-11:14
 * 这题用set解释，需要数学证明
 */
public class leetCode202 {
    @Test
    public void Test(){
        boolean flag=isHappy(19);
    }
    public boolean isHappy(int n) {
        Set<Integer> set=new HashSet<>();
        while(getNext(n)!=1){
            n=getNext(n);
            if(set.contains(n)) return false;
            set.add(n);
        }
        return true;
    }
    public int getNext(int number){
        int next=0;
        while(number>0){
            int temp=number%10;
            next+=temp*temp;
            number/=10;
        }
        return next;
    }
}
