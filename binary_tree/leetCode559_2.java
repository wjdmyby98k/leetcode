package binary_tree;

/**
 * @author：THIEM
 * @create:2021/9/3-12:23
 * 用递归写,自己写出来的！！！！！！
 */
public class leetCode559_2 {
    int result=0;
    public int maxDepth(Node root) {
        if(root==null) return 0;
        getMaxDepth(root,1);
        return result;
    }
    public void getMaxDepth(Node node,int depth){
        result=depth>result? depth:result;
        if(node.children==null) return ;
        for(Node node1 : node.children){
            getMaxDepth(node1,depth+1);
        }
    }
}
