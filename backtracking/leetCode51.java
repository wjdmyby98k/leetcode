package backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author：THIEM
 * @create:2021/9/29-21:42
 * 这是一道hard，后面慢慢写吧，N皇后问题
 */
public class leetCode51 {
    @Test
    public void  Test1(){
        char[][] chessboard=new char[][]{{'a','x','c'},{'a','d','r'}};
        System.out.println(Array2List(chessboard));
    }
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard=new char[n][n];  //定义一个n x n 棋盘
        for(char[] c:chessboard){
            Arrays.fill(c,'.');       // 棋盘初始化
        }
        backtracking(n,0,chessboard);
        return result;
    }
    public void backtracking(int n,int row,char[][] chessboard) {
        if (row == n) {  //为什么需要参数n，就是为了这个终止条件，当然，不传也行，用chessboard的length,但是这样会比较麻烦
            result.add(Array2List(chessboard));
            return;
        }
        for(int col=0;col<n;col++){
            if (isValid(row,col,n,chessboard)){
                chessboard[row][col]='Q';
                backtracking(n,row+1,chessboard);
                chessboard[row][col]='.';
            }
        }
    }
    public List Array2List(char[][] chessboard) {
        List<String> list = new ArrayList<>();

        for (char[] c : chessboard) {
            list.add(String.copyValueOf(c));   //把每个一维的字符数组转换成string，放在list里面
        }
        return list;
    }
    public boolean isValid(int row,int col,int n,char[][] chessboard){
        // （row，col） 这个位置放进去合不合法，所以只需要关注row前，col前，后面的不用管，因为后面没放
        // 即 只需要考虑45° 和 135°，以及行和列，因为一行只放一个，然后就进入下一个回溯了，所以不需要考虑行
        //列
        for(int i=0;i<row;i++){
            if(chessboard[i][col]=='Q'){
                return false;
            }
        }
        // 45°
        for (int i=row-1,j=col+1;i>=0 && j<=n-1;i--,j++){  //注意这里是j=col+1.且j++，j<=n-1
            if(chessboard[i][j]=='Q'){
                return false;
            }
        }
        //135°
        for (int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(chessboard[i][j]=='Q'){
                return false;
            }
        }

        return true;
    }
}
