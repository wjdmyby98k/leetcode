package daily_one_problem;

import org.junit.Test;

/**
 * @author：THIEM
 * @create:2021/11/24-2:54
 * 数组优化
 */
public class leetCode423_2 {
    @Test
    public void test(){
        StringBuffer stringBuffer=new StringBuffer();
        for(long i=0;i<10000;i++){
            stringBuffer.append("abcdfg");
        }
        String s= stringBuffer.toString();
        long startTime1 = System.currentTimeMillis();    //获取开始时间
        int[] nums1=new int[26];
        for(int i=0;i<s.length();i++){
            nums1[s.charAt(i)-'a']++;
        }
        long endTime1 = System.currentTimeMillis();    //获取结束时间
        long time1=endTime1-startTime1;
        long startTime2 = System.currentTimeMillis();    //获取开始时间
        int[] nums2=new int[26];
        for(char ch : s.toCharArray()) { // 事实证明，用s.toCharArray会快一点
            nums2[ch - 'a']++;
        }
        long endTime2 = System.currentTimeMillis();    //获取结束时间
        long time2=endTime2-startTime2;
        System.out.println("time1="+time1+",time2="+time2);  // time1=3,time2=1
    }
    public String originalDigits(String s) {
        StringBuffer sb=new StringBuffer();
        int[] nums=new int[26];
//        for(int i=0;i<s.length();i++){
//            nums[s.charAt(i)-'a']++;
//        }
        for(char ch : s.toCharArray()) { // 事实证明，用s.toCharArray会快一点
            nums[ch - 'a']++;
        }
        int[] cnt= new int[10];
        cnt[0]=nums['z'-'a'];
        cnt[2]=nums['w'-'a'];
        cnt[4]=nums['u'-'a'];
        cnt[6]=nums['x'-'a'];
        cnt[8]=nums['g'-'a'];
        cnt[1]=nums['o'-'a']-cnt[0]-cnt[2]-cnt[4];
        cnt[7]=nums['s'-'a']-cnt[6];
        cnt[5]=nums['f'-'a']-cnt[4];
        cnt[3]=nums['h'-'a']-cnt[8];
        cnt[9]=nums['i'-'a']-cnt[5]-cnt[6]-cnt[8];
        for(int i=0;i<10;i++){
            for(int j=0;j<cnt[i];j++){
                sb.append(i);
            }
        }
        return sb.toString();
    }
}
