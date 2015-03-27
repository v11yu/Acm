package leetcode.unsolve;
/**
 * https://leetcode.com/problems/sudoku-solver/
 * 
 * @author v11
 */
public class SudokuSolver {
	int r[] = new int[9];
	int l[] = new int[9];
	int m[] = new int[9];
	char[][] ans = new char[9][9];
	char[][] tmp = new char[9][9];
	int findM(int i,int j){return ((i+1)/3)*((j+1)/3)-1;}
	boolean check1(int num,int s){return ((1<<num)&s)!=0?false:true;}
	boolean check(int i,int j,int num){
		return check1(r[i],num)&&check1(l[j],num)&&check1(findM(i,j),num);
	}
	void set(int i,int j,int num){
		int tmp = (1<<num);
		r[i] ^= tmp;
		l[j] ^= tmp;
		m[findM(i,j)] ^= tmp;
		ans[i][j] = (char) (num+'0');
	}
	void copyChar(char[][] s,char[][] t){
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++)
				t[i][j] = s[i][j];
		}
	}
	void dfs(int deep){
		if(deep == 89){
			copyChar(ans, tmp);
			return ;
		}
		int x = deep/9;
		int y = deep%9;
		for(int i=1;i<=9;i++){
			if(check(x,y,i)){
				set(x,y,i);
				dfs(deep+1);
				set(x,y,i);
			}
		}
	}
	public void solveSudoku(char[][] b) {
		copyChar(b, ans);
		dfs(0);
		copyChar(tmp, b);
	}
}
