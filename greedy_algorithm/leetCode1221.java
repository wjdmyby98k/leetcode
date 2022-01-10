package greedy_algorithm;

/**
 * @author：THIEM
 * @create:2021/12/24-15:04
 * 简答题贪心！
 */
public class leetCode1221 {
    public int balancedStringSplit(String s) {
        int cnt=0;
        int ans =0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='R'){
                cnt++;
            }else {
                cnt--;
            }
            if(cnt==0){
                ans++;
            }
        }
        return ans;
    }
}
