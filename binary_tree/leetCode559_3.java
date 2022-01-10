package binary_tree;

/**
 * @author：THIEM
 * @create:2021/9/3-12:41
 * 更简洁的一种递归
 */
public class leetCode559_3 {
    public int maxDepth(Node root) {
        if(root==null) return 0;
        int depth=0;
        for(Node child : root.children){
            depth= Math.max(depth,maxDepth(child));
        }
        return depth+1;
    }
}
