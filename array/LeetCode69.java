package array;

/**
 * @author：THIEM
 * @creat:2021/7/10-12:23
 * 相当于在找数的左边界
 */
public class LeetCode69 {
    public int mySqrt(int x) {
        if(x==0) return 0;
        if(x==1) return 1;
        int left=0;
        int right =x;
        //因为最后只剩一个点的时候，left==right，且其余区间都找过，没有满足的，就是此时是非整数的情况。找此时的左边界即可，即返回right
        while(left<=right){
            int mid=left+(right-left)/2;
            if(x/mid<mid){
                right=mid-1;
            }
            else if(x/mid>mid){
                left=mid+1;
            }
            else{
                return mid;
            }
        }
        return right;
    }
}

