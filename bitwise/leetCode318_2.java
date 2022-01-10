package bitwise;

/**
 * @author：THIEM
 * @create:2021/11/17-1:34
 * 位运算，掩码bitmask，每个int32位，将每个字符串用位运算表示成一个int的数字就行，只用到int32位中的26位
 * m是单词平均长度，n是单词个数
 */
public class leetCode318_2 {
    public int maxProduct(String[] words) {
        int n=words.length;
        int [] masks =new int[n];  // 存放每个单词的掩码
        int bitmask;
        // O(mn)
        for(int i=0;i<n;i++){
            bitmask=0;
            char[] chars=words[i].toCharArray();
            for(char c : chars){
                bitmask|=1<<(c-'a');
            }
            masks[i]=bitmask;
        }

        // O(n^2)
        int ans=0;
        for(int i=0;i<n;i++){   // 双重循环计算最大值
            String word1=words[i];
            for(int j=i+1;j<n;j++){
                String word2=words[j];
                if((masks[i] & masks[j])==0){
                    ans=Math.max(word1.length()*word2.length(),ans);
                }
            }
        }
        return ans;
    }
}
