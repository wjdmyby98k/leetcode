package hashTable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author：THIEM
 * @create:2021/7/23-10:30
 */
public class leetCode1002 {
    public List<String> commonChars(String[] words) {
        List<String> list= new ArrayList<>();
        if(words.length==0) return list;
        int[] hash= new int[26];
        for(int i=0;i<words[0].length();i++){
            hash[words[0].charAt(i)-'a']++;
        }
        for(int i=1;i<words.length;i++){
            int[] otherHash=new int[26];
            for(int j=0;j<words[i].length();j++){
                otherHash[words[i].charAt(j)-'a']++;
            }
            for(int k=0;k<26;k++){
                hash[k]= Math.min(hash[k],otherHash[k]);      //update hash[]
            }
        }
        for(int i=0;i<26;i++){
            while(hash[i]!=0){
                char char1=(char)(i+'a');              //is i+'a',not hash[i]!!!
                String s=String.valueOf(char1);   //static method of String! Remember
                hash[i]--;
                list.add(s);
            }
        }

        return list;
    }
}
