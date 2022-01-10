package daily_one_problem;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author：THIEM
 * @create:2021/11/24-2:21
 * 可以用数组优化
 */
public class leetCode423 {
    @Test
    public void Test(){
        StringBuffer sb =new StringBuffer();
        sb.append(1);
        sb.append(1);
        System.out.println(sb.toString());
    }
    public String originalDigits(String s) {
        int[] cnt=new int[10];
        HashMap<String,Integer> hashMap=new HashMap();
        String s1;
        for(int i=0;i<s.length();i++){
            s1=String.valueOf(s.charAt(i));
            hashMap.put(s1,hashMap.getOrDefault(s1,0)+1);
        }
        // 记得全部要用hashMap.getOrDefault,不能用get，不存在key的时候返回的是null
        cnt[0]=hashMap.getOrDefault("z",0);
        cnt[2]=hashMap.getOrDefault("w",0);
        cnt[4]=hashMap.getOrDefault("u",0);
        cnt[6]=hashMap.getOrDefault("x",0);
        cnt[8]=hashMap.getOrDefault("g",0);
        cnt[1]=hashMap.getOrDefault("o",0)-cnt[0]-cnt[2]-cnt[4];
        cnt[7]=hashMap.getOrDefault("s",0)-cnt[6];
        cnt[5]=hashMap.getOrDefault("f",0)-cnt[4];
        cnt[3]=hashMap.getOrDefault("h",0)-cnt[8];
        cnt[9]=hashMap.getOrDefault("i",0)-cnt[5]-cnt[6]-cnt[8];
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<10;i++){
            if(cnt[i]!=0){
                for(int j=0;j<cnt[i];j++){
                    sb.append(i);
                }
            }
        }
        return sb.toString();
    }
}
