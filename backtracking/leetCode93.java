package backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author：THIEM
 * @create:2021/8/31-21:24
 * substring 的方法，有两个重写，注意区分！！！，这题关键就是substring的拼接，会改变原来的s，然后就是输出格式的要求
 * 用StringBuilder应该也可以做，只是删除的时候麻烦一点！解法1自己做的！
 * path如果是个列表，方便remove了，但是list不方便转为string，输出格式会有问题
 * 解法1，用StringBuilder做的,循环终止条件那里有个细节，需要注意实际上只需要找前面三段就行，前面三段回溯就行了
 * 解法2用carl思路写，直接操作s
 */
public class leetCode93 {
//    @Test
//    public void Test1(){
//        String s="abed";
//        for(int i=0;i<3;i++){
//            s=s.substring(0,1)+"."+s.substring(1,2);
//            System.out.println(s);
//        }
//    }
    @Test
    public void Test2(){
        String s=new String("25525511135");
        List<String> ans=restoreIpAddresses(s);
        System.out.println(ans);
    }
    List<String> result= new ArrayList<>();
    StringBuilder path=new StringBuilder();
    int nodeSize=0;
    public List<String> restoreIpAddresses(String s) {
        backtracking(s,0,0);
        return result;
    }
    public void backtracking(String s,int startIndex,int nodeSize){
        if(nodeSize==3){
            if(isValid(s,startIndex,s.length()-1)){
                path.append(s.substring(startIndex,s.length()));
                result.add(path.toString());
                path.delete(path.length()-s.length()+startIndex,path.length());  //这一步很重要！！！
            }
            return;
        }
        for(int i=startIndex;i<s.length();i++){
            if(isValid(s,startIndex,i)){
                path.append(s.substring(startIndex,i+1));
                path.append(".");
                nodeSize++;
                backtracking(s,i+1,nodeSize);
                nodeSize--;
                path.delete(path.length()-1,path.length());   //删除句号
                path.delete(path.length()-i-1+startIndex,path.length());  //删除新加的子串
            }else { //出现一个区间不合法，后面也都会不合法
                break;
            }
        }
    }
    public boolean isValid(String s,int startIndex,int end){  //左闭右闭
        if(startIndex>end){
            System.out.println(startIndex);
            System.out.println(end);
            return false;
        }
        if(s.charAt(startIndex)=='0' && startIndex!=end){
            return false;
        }
        int sum=0;
        for(int i=startIndex;i<=end;i++){
            sum=sum*10+(s.charAt(i)-'0');
            if(sum>255){
                return false;
            }
        }
        return true;
    }
}
