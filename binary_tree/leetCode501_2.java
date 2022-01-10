package binary_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author：THIEM
 * @create:2021/9/15-20:43
 * 递归
 * 用中序写，直接遍历一遍，就能得出结果，用一个指针，记录前一个结点
 */
public class leetCode501_2 {
    TreeNode pre=null;
    int maxCount=0;
    int count=0;
    List<Integer> resultList = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        traversal(root);
        int [] ans =new int[resultList.size()];
        for(int i=0;i<resultList.size();i++){
            ans[i]=resultList.get(i);
        }
        return ans;
    }
    public void traversal(TreeNode root){
        if(root==null) return;
        traversal(root.left);
        if(pre==null || pre.val<root.val){
            count=1;
        }else{
            count++;
        }
        //更新最大频次
        if(count>maxCount){
            maxCount=count;
            resultList.clear();
            resultList.add(root.val);
        }else if(count==maxCount){
            resultList.add(root.val);
        }
        //if count<maxCount就继续下一个，不用写
        pre=root;//更新pre
        traversal(root.right);
    }
}
