package array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author：THIEM
 * @creat:2021/7/7-13:52
 * 59类似
 */
public class LeetCode54 {
    @Test
    public void Test(){
        int[][] matrix=new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> list = spiralOrder(matrix);
        System.out.println(list);
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List list=new ArrayList();
        int m=matrix.length;  //行
        int n=matrix[0].length;//列
        int l=0,t=0,r=n-1,b=m-1;
        int sum=0,count=m*n;
        while (sum<count){
            for(int i=l;i<=r;i++){
                if(sum==count)
                    break;
                list.add(matrix[t][i]);
                sum++;
            }
            t++;
            for(int i=t;i<=b;i++){
                if(sum==count)
                    break;
                list.add(matrix[i][r]);
                sum++;
            }
            r--;
            for(int i=r;i>=l;i--){
                if(sum==count)
                    break;
                list.add(matrix[b][i]);
                sum++;
            }
            b--;
            for(int i=b;i>=t;i--){
                if(sum==count)
                    break;
                list.add(matrix[i][l]);
                sum++;
            }
            l++;
        }
        return list;
    }
}
