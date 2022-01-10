package binary_tree;


import java.util.*;

/**
 * @author：THIEM
 * @create:2021/9/15-15:39
 * 暴力解法，用hashmap存储，然后用collections工具类排序，可以用lambda表达式
 */
public class leetCode501 {
    HashMap<Integer,Integer> map=new HashMap();
    public int[] findMode(TreeNode root) {
        traversal(root);
        Set<Map.Entry<Integer,Integer>> entrySet=map.entrySet(); //得到频次
        List<Map.Entry<Integer,Integer>> list=new ArrayList<>(entrySet);//将set转换为list
        //collections只能放list和comparator,构造一个比较器，进行值排序,注意是降序
        Comparator<Map.Entry<Integer,Integer>> comparator=(o1, o2) -> o2.getValue()-o1.getValue();
        Collections.sort(list,comparator);
        List<Integer> result=new ArrayList<>();
        result.add(list.get(0).getKey()); //把第一个放进去
        for(int i=1;i<list.size();i++){
            if(list.get(i).getValue()==list.get(0).getValue()){
                result.add(list.get(i).getKey());
            }else {
                break;
            }
        }
        //再讲result里面的结果用数组存起来
        int[] ans= new int[result.size()];
        for(int i=0;i<result.size();i++){
            ans[i]=result.get(i);
        }
        return  ans;



    }
    public void traversal(TreeNode root){
        if(root==null){
            return;
        }
        traversal(root.left);
        map.put(root.val,map.getOrDefault(root.val,0)+1);
        traversal(root.right);
        return;
    }
}
