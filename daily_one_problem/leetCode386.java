package daily_one_problem;

import java.util.LinkedList;
import java.util.List;

/**
 * @author：THIEM
 * @create:2021/12/16-15:01
 * 很久没写递归了
 */
public class leetCode386 {
    List<Integer> ans = new LinkedList<>();
    public List<Integer> lexicalOrder(int n) {
        for (int i=1;i<10;i++){
            dfs(n,i,ans);
        }
        return ans;
    }
    public void dfs(int n,int i,List<Integer> ans){
        if(i>n) return;
        ans.add(i);
        for(int j=0;j<10;j++){
            dfs(n,i*10+j,ans);
        }
    }
}
