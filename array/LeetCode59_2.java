package array;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author：THIEM
 * @creat:2021/7/7-0:20
 * 打印螺旋矩阵
 */
public class LeetCode59_2 {
    @Test
    public void Test(){
        System.out.println(Arrays.deepToString(generateMatrix1(3)));
    }
    public int[][] generateMatrix(int n){
        int[][] matrix=new int[n][n];
        int startX=0;
        int startY=0;
        int sum=1;
        int offset=1;
        int i,j;
        while(sum<n*n){
            for(j=startY;j<n-offset;j++){
                matrix[startX][j]=sum;
                sum++;
            }
            for(i=startX;i<n-offset;i++){
                matrix[i][j]=sum;
                sum++;
            }
            for(;j>startY;j--){
                matrix[i][j]=sum;
                sum++;
            }
            for(;i>startX;i--){
                matrix[i][j]=sum;
                sum++;
            }
            startX++;
            startY++;
            offset++;
        }
        if(n%2==1){
            matrix[n/2][n/2]=n*n;
        }
        return matrix;
    }

    //建议用下面这种方法，思路清晰
    public int[][] generateMatrix1(int n){
        int[][] matrix=new int[n][n];
        int l=0,r=n-1,t=0,b=n-1;
        int sum=1;
        while (sum<=n*n){
            for(int i=l;i<=r;i++){
                matrix[t][i]=sum++;
            }
            t++;
            for(int i=t;i<=b;i++){
                matrix[i][r]=sum++;
            }
            r--;
            for(int i=r;i>=l;i--){
                matrix[b][i]=sum++;
            }
            b--;
            for(int i=b;i>=t;i--){
                matrix[i][l]=sum++;
            }
            l++;
        }

        return matrix;
    }

}
