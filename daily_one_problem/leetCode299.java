package daily_one_problem;

import java.util.HashMap;

/**
 * @author：THIEM
 * @create:2021/11/8-17:13
 * 思路，第一遍找对齐的，第二遍找不对齐相等的，map只记录不对齐的
 * 自己写的，击败百分之17
 */
public class leetCode299 {
    public String getHint(String secret, String guess) {
        int countA=0;
        int countB=0;
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        for(int i=0;i<secret.length();i++){
            if(secret.charAt(i)==guess.charAt(i)){
                countA++;
            }
        }
        for(int i=0;i<secret.length();i++){ // 把secret的频次存起来,不包含对齐的
            if(secret.charAt(i)==guess.charAt(i)){
                continue;
            }
            int value=Integer.parseInt(String.valueOf(secret.charAt(i)));
            hashMap.put(value,hashMap.getOrDefault(value,0)+1);
        }
        for(int j=0;j<guess.length();j++){
            if(secret.charAt(j)==guess.charAt(j)){
                continue;
            }
            int value1 = Integer.parseInt(String.valueOf(secret.charAt(j)));
            int value2 = Integer.parseInt(String.valueOf(guess.charAt(j)));
            if(hashMap.containsKey(value2) && hashMap.get(value2)>0){
                countB++;
                hashMap.put(value2,hashMap.get(value2)-1);
            }
        }
        String ans=countA+"A"+countB+"B";
        return ans;
    }
}
