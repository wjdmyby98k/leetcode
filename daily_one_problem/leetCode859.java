package daily_one_problem;

/**
 * @author：THIEM
 * @create:2021/11/23-20:40
 * 宫水三叶的题解思路
 */
public class leetCode859 {
    public boolean buddyStrings(String s, String goal) {
        int m=s.length();
        int n=goal.length();
        if(m!=n) return false;
        int[] cnt1=new int[26];
        int[] cnt2=new int[26];
        int sum=0; // 统计对应位置不同的个数，要想交换，①必须只能是0个且存在重复的字母    ②2个，长度大于等于3
        for(int i=0;i<m;i++){
            cnt1[s.charAt(i)-'a']++;
            cnt2[goal.charAt(i)-'a']++;
            if(s.charAt(i)!=goal.charAt(i)){
                sum++;
            }
        }
        boolean ok=false;
        for(int i=0;i<26;i++){
            if(cnt1[i]!=cnt2[i]) return false; //对应字母个数都不一样，肯定false
            if(cnt1[i]>1) ok=true; //代表都 存在一个重复的字母
        }
        return sum==2 ||(sum==0 && ok);
    }
}
