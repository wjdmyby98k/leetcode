package bitwise;

/**
 * @author：THIEM
 * @create:2021/11/17-1:29
 * 暴力解法
 * m表示单词的平均长度，n 表示单词的个数
 * 时间复杂度：O(n^2 * m)
 * 空间复杂度：O(1)
 */
public class leetCode318 {
    public int maxProduct(String[] words) {
        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            String word1 = words[i];
            for (int j = i + 1; j < words.length; j++) {
                String word2 = words[j];
                // 每个单词的 bitMask 会重复计算很多次
                if (!hasSameChar(word1, word2)) {
                    ans = Math.max(ans, word1.length() * word2.length());
                }
            }
        }
        return ans;
    }
    // O(m^2)
    private boolean hasSameChar(String word1, String word2) {
        for (char c : word1.toCharArray()) {
            if (word2.indexOf(c) != -1) return true;  // 这里是线性查找，所以也是O（m）
        }
        return false;
    }
    // 可以改进为O（m）
    // O(m)
    private boolean hasSameChar2(String word1, String word2) {
        int[] count = new int[26];
        for (char c : word1.toCharArray()) count[c - 'a'] = 1;
        for (char c : word2.toCharArray()) {
            if (count[c - 'a'] == 1) return true;
        }
        return false;
    }


}
