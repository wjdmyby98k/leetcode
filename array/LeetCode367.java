package array;

import org.junit.Test;

/**
 * @author：THIEM
 * @create:2021/7/10-15:05
 */

public class LeetCode367 {
    @Test
    public void Test(){
        System.out.println(isPerfectSquare(5));
    }
    public boolean isPerfectSquare(int num) {
        if(num==1) return true;
        // if(x==2 || x==3) return false;
        int left=0;
        int right =num;

        while(left<=right){
            int mid=left+(right-left)/2;
            if(num/mid<mid){
                right=mid-1;
            }
            else if(num/mid>mid){
                left=mid+1;
            }
            else{
                if(mid*mid==num) return true;
                return false;
            }
        }
        return false;
    }
}
