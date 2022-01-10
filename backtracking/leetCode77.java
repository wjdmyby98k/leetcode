package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author：THIEM
 * @create:2021/8/30-18:57
 * 组合问题
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 */
public class leetCode77 {
    List<List<Integer>> result=new ArrayList<>();
    LinkedList<Integer> path=new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtracking(n,k,1);
        return result;
    }
    public void backtracking(int n,int k,int startIndex){
        if(path.size()==k){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=startIndex;i<=n;i++){
            path.add(i);
            backtracking(n,k,i+1);
            path.removeLast();
        }
    }
}
