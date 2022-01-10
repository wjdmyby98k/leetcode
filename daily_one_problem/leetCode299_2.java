package daily_one_problem;

/**
 * @author：THIEM
 * @create:2021/11/10-20:44
 * 不用hashmap，用数组优化,但是空间消耗还是很高，不懂，时间击败百分之60，内存百分之9
 */
public class leetCode299_2 {
    public String getHint(String secret, String guess) {
        int countA=0;
        int countB=0;
        int[] hashmap=new int[10];
        for(int i=0;i<secret.length();i++){
            if(secret.charAt(i)==guess.charAt(i)){
                countA++;
            }
        }
        for(int i=0;i<secret.length();i++){ // 把secret的频次存起来,不包含对齐的
            if(secret.charAt(i)==guess.charAt(i)){
                continue;
            }
            hashmap[secret.charAt(i)-'0']++;
        }
        for(int j=0;j<guess.length();j++){
            if(secret.charAt(j)==guess.charAt(j)){
                continue;
            }else {
                if(hashmap[guess.charAt(j)-'0']>0){
                    hashmap[guess.charAt(j)-'0']--;
                    countB++;
                }
            }
        }
        String ans=countA+"A"+countB+"B";
        return ans;
    }
}
