package backtracking;

import org.junit.Test;

/**
 * @author：THIEM
 * @create:2021/9/17-22:03
 * 回溯
 */
public class leetCode37 {
    @Test
    public void Test1(){
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        solveSudoku(board);
    }



    public void solveSudoku(char[][] board) {
        backtracking(board);
    }
    public boolean backtracking(char[][] board){
        for(int row=0;row<9;row++){
            for(int col=0;col<9;col++){
                if(board[row][col]!='.'){
                    continue;
                }
                for(char k='1';k<='9';k++){
                    if (isValid(row,col,k,board)){
                        board[row][col]=k;
                        if(backtracking(board)){
                            return true;
                        }
                        board[row][col]='.';
                    }
                }

                return false;
            }
        }
        return true;
    }
    public boolean isValid(int row,int col,char k,char[][] board){
        for(int i=0;i<9;i++){
            if(board[row][i]==k){
                return false;
            }
        }
        for(int i=0;i<9;i++){
            if(board[i][col]==k){
                return false;
            }
        }
        int startRow=(row/3)*3;
        int startCol=(col/3)*3;
        for (int i=startRow;i<startRow+3;i++){
            for(int j=startCol;j<startCol+3;j++){
                if(board[i][j]==k){
                    return false;
                }
            }
        }
        return true;
    }
}
