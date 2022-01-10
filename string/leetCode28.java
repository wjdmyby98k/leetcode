package string;

/**
 * @author：THIEM
 * @create:2021/8/9-17:02
 * KMP
 *
 */
public class leetCode28 {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0) return 0;
        if(haystack.length()==0) return -1;
        int[] next=new int[needle.length()];
        getNext(needle,next);
        int j=-1;// 因为next数组里记录的起始位置为-1
        for(int i=0;i<haystack.length();i++){// 注意i就从0开始
            while(j>=0 && haystack.charAt(i)!=needle.charAt(j+1)){// 不匹配
                j=next[j];// j 寻找之前匹配的位置
            }
            if(haystack.charAt(i)==needle.charAt(j+1)){// 匹配，j和i同时向后移动
                j++; // i的增加在for循环里
            }
            if(j==needle.length()-1) return i-j;// 文本串s里出现了模式串t
        }
        return -1;
    }
    public void getNext(String needle,int[] next){
        int j=-1;       //j表示前缀末尾，i表示后缀末尾
        next[0]=-1;

        for(int i=1;i<needle.length();i++){
            //注意i从1开始
            //我们此时知道了 [0,i-1]的最长前后缀，但是j+1的指向的值和i不相同时，我们则需要回溯
            //因为 next[j]就时用来记录子串的最长公共前后缀的尾坐标（即长度）
            //就要找 j+1前一个元素在next数组里的值,即next[k+1]
            while(j>=0 && needle.charAt(j+1)!=needle.charAt(i)){//不匹配，j>=0是保证j没有回到-1开始的位置
                j=next[j];      //j向前回溯
            }
            // 相同情况，就是 k的下一位，和 i 相同时，此时我们已经知道 [0,i-1]的最长前后缀是j
            //加1，即可
            if(needle.charAt(j+1)==needle.charAt(i)){
                j++;
            }
            next[i]=j;
        }
    }

}
