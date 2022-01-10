package hashTable;

/**
 * @author：THIEM
 * @create:2021/7/15-8:37
 */
public class leetCode383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] table =new int[26];

        for(int i=0;i<magazine.length();i++){
                table[magazine.charAt(i)-'a']++;
        }
        for(int i=0;i<ransomNote.length();i++){
            table[ransomNote.charAt(i)-'a']--;
            if(table[ransomNote.charAt(i)-'a']<0){
                return false;
            }
        }
        return true;
    }
}
