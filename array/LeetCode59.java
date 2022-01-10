package array;

//打印螺旋矩阵
public class LeetCode59 {
    //方法2
    public int[][] printMatrix2(int n){
        int[][] ans= new int[n][n];
        int startX=0;
        int startY=0;
        int offset=1;
        int count=1;
        while(count<n*n){
            int i=startX;
            int j=startY;
            for(j=startY;j<n-offset;j++){
                ans[i][j]=count++;
            }
            for(i=startX;i<n-offset;i++){
                ans[i][j]=count++;
            }
            for(;j>startY;j--){
                ans[i][j]=count++;
            }
            for(;i>startX;i--){
                ans[i][j]=count++;
            }
            startX++;
            startY++;
            offset+=1;

        }
        if(n%2==1) ans[n/2][n/2]=count;
        return ans;
    }
    //方法1
    public int[][] printMatrix1(int n){
        int[][] ans= new int[n][n];
        int startX=0;
        int startY=0;
        int loop=n/2;
        int offset=1;
        int count=1;
        while(loop>0){
            int i=startX;
            int j=startY;
            for(j=startY;j<n-offset;j++){  //结束后 i=0,j=n-1
                ans[i][j]=count++;
            }
            for(i=startX;i<n-offset;i++){   //结束后 i=n-1.j=n-1
                ans[i][j]=count++;
            }
            for(;j>startY;j--){
                ans[i][j]=count++;
            }
            for(;i>startX;i--){
                ans[i][j]=count++;
            }
            loop--;
            startX++;
            startY++;
            offset+=1;
        if(n%2==1){
            ans[n/2][n/2]=count;
            }

        }
        return ans;

    }

    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        System.out.println("start="+start);
        LeetCode59 leetcode2 = new LeetCode59();
        int[][] ans=leetcode2.printMatrix2(10);
        for (int i=0;i<ans[0].length;i++) {
            for(int j=0;j<ans[0].length;j++){
                System.out.print(ans[i][j]);
                System.out.print(" ");
            }
            System.out.println("");
        }
        long end =System.currentTimeMillis();
        System.out.println("end="+end);
        int time=  (int)(start-end);
        System.out.println("time="+time);
    }
}
