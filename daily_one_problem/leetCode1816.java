package daily_one_problem;

/**
 * @author：THIEM
 * @create:2021/12/6-19:00
 * 简单题重拳出击
 */
public class leetCode1816 {
    public String truncateSentence(String s, int k) {
        int cnt=0;
        StringBuffer ans =new StringBuffer();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                cnt++;
            }
            if(cnt==k) break;
            ans.append(s.charAt(i));
        }
        return ans.toString();
    }
}
