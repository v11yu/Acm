package leetcode.problem;

public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		int col[] = new int[9];
		int row[] = new int[9];
		int m[] = new int[9];
		int ipow[] = new int[9];
		ipow[0]=1;
		for(int i=1;i<ipow.length;i++) ipow[i] = ipow[i-1]*2;
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[i].length;j++){
				if(board[i][j]!='.'){
					int num = board[i][j] - '0'-1;
					int idx = (i/3)*3 +j/3;
					if( (col[i]&ipow[num])!=0 || (row[j]&ipow[num])!=0 ||
							(m[idx]&ipow[num])!=0 )
						return false;
					col[i] |= ipow[num];
					row[j] |= ipow[num];
					m[idx] |= ipow[num];
				}
			}
		}
		return true;
	}
}
