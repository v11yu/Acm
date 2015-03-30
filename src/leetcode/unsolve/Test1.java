package leetcode.unsolve;

import java.util.HashMap;
import java.util.Map;

public class Test1 {
	boolean[][] row = new boolean[9][9];
	boolean[][] col = new boolean[9][9];
	boolean[][] blo = new boolean[9][9];
	char ans[][];
	public void solveSudoku(char[][] board) {
	    for(int i=0;i<9;i++)
	        for(int j =0;j<9;j++){
	            int temp =board[i][j]-'1';
	            if(board[i][j]!='.'){
	                row[i][temp]=true;
	                col[j][temp]=true;
	                blo[3*(i/3)+j/3][temp]=true;
	            }
	        }
	    solveHelper(0,0,board);
	    ans = board;
	}
	public boolean solveHelper(int i, int j, char[][] board){
	    if(i==9)
	        return true;
	    if(board[i][j]!='.'){
	        if(j<8)
	            return solveHelper(i,j+1,board);
	        else 
	            return solveHelper(i+1,0,board);
	    }else for(int k =0;k<9;k++){
	            if(row[i][k]==false&&col[j][k]==false&&blo[3*(i/3)+j/3][k]==false){
	                board[i][j] = (char)(k+'0'+1);
	                row[i][k]=true;
	                col[j][k]=true;
	                blo[3*(i/3)+j/3][k]=true;
	                if(j<8&&solveHelper(i,j+1,board))
	                    return true;
	                else if(j==8&&solveHelper(i+1,0,board))
	                    return true;
	                else{
	                    board[i][j] = '.';
	                    row[i][k]=false;
	                    col[j][k]=false;
	                    blo[3*(i/3)+j/3][k]=false;
	                }
	            }
	        }
	    return false;
	}
	void show(){
		for(int i=0;i<9;i++){
			System.out.println(new String(ans[i]));
		}
		System.out.println();
	}
	public static void main(String[] args) {
		String str[] = {".....7..9",".4..812..","...9...1.","..53...72","293....5.",".....53..","8...23...","7...5..4.","531.7...."};
		char[][] b = new char[9][];
		for (int i = 0; i < 9; i++)
			b[i] = str[i].toCharArray();
		Test1 t = new Test1();
		t.solveSudoku(b);
		t.show();
	}
}
