package greedy_algorithm;

/**
 * @author：THIEM
 * @create:2021/10/6-1:28
 * carl题解，这题贪心是按照顺序来的，如果可以同时多个顾客，就对数组排序就好了
 */
public class leetCode860 {
    public boolean lemonadeChange(int[] bills) {
        int five=0;
        int ten=0;
        int twenty=0;
        for (int bill:bills){
            if(bill==5){
                five++;
            }else if(bill==10){
                if(five>0){
                    five--;
                    ten++;
                }else {
                    return false;
                }
            }else if(bill==20){
                if(five>0 && ten>0){
                    five--;
                    ten--;
                    twenty++;
                }else {
                    if(five>3){
                        five-=3;
                        twenty++;
                    }
                    else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
