package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author：THIEM
 * @create:2021/8/30-19:17
 * 组合问题3
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 */
public class leetCode216 {
    List<List<Integer>> result=new LinkedList<>();
    LinkedList<Integer> path=new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k,n,1,0);
        return result;
    }
    public void backtracking(int k,int n,int startIndex,int sum){
        //终止条件
        if(path.size()==k){   //只要个数是k，就要返回，如果满足条件，多一个添加操作
            if(sum==n){
                result.add(new ArrayList<>(path));
            }
            return;
        }
        //剪枝
        if(sum>n){
            return;
        }
        //剪枝
        for(int i=startIndex;i<=9-(k-path.size())+1;i++){
            sum+=i;
            path.add(i);
            backtracking(k,n,i+1,sum);
            path.removeLast();
            sum-=i;
        }
    }
}
