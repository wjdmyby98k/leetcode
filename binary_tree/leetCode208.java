package binary_tree;

import org.junit.Test;

/**
 * @author：THIEM
 * @create:2021/12/29-22:03
 * 前缀树
 */

public class leetCode208 {
    @Test
    public void Test(){
        Trie A = new Trie();
        System.out.println(A);
    }
}
// 前缀树的结点结构
class TrieNode {
    boolean isWord;//是否是单词
    TrieNode[] children;//26个小写字母

    public TrieNode() {
        isWord = true;
        children = new TrieNode[26];
    }
}
class Trie{
    //根节点，根节点是不存储任何字母的，从根节点的
    //子节点开始存储
    private TrieNode root;
    public Trie(){
        this.root=new TrieNode();
    }
    public void insert(String word){
        TrieNode cur = root;
        for (int i =0;i<word.length();i++){
            int index = word.charAt(i) - 'a';
            if(cur.children[index]==null){
                cur.children[index]=new TrieNode();
                cur.children[index].isWord=false;
            }
            cur=cur.children[index];
        }
        cur.isWord=true;
    }
    public boolean search(String word){
        TrieNode cur = find(word);
        return cur!=null && cur.isWord;
    }
    public boolean startsWith(String prefix){
        return find(prefix)!=null;
    }
    public TrieNode find(String str){
        TrieNode cur = root;
        int length=str.length();
        for (int i =0;i<length;i++){
            int index = str.charAt(i)-'a';
            cur=cur.children[index];
            if(cur==null){
                return null;
            }
        }
        return cur;
    }
}


