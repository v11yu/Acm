package leetcode.problem;
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
	boolean flag = false;
	int tmp = -1;
	int findM(int i, int j) {return (i/3)*3 +j/3;}
	boolean check1(int s, int num) {return ((1 << num) & s) != 0 ? false : true;}
	boolean check(int i, int j, int num) {
		return check1(r[i], num) && check1(l[j], num)&& check1(m[findM(i, j)], num);
	}
	void set(int i, int j, int num) {
		int tmp = (1 << num);
		r[i] ^= tmp;
		l[j] ^= tmp;
		m[findM(i, j)] ^= tmp;
	}
	void show(){
		for(int i=0;i<9;i++){
			System.out.println(new String(ans[i]));
		}
		System.out.println();
	}
	void dfs(int deep) {
		if (deep == 81) {
			flag = true;
			return;
		}
		int x = deep / 9;
		int y = deep % 9;
		//System.out.println(deep+" "+x+" "+y);
		//if(deep == 39) show();
		for (int i = 1; i <= 9; i++) {
			if (flag) break;
			if(ans[x][y] !='.'){
				dfs(deep+1);
				break;
			}
			else if (ans[x][y]=='.'&&check(x, y, i)) {
				//if(deep == 1&&ans[0][0]=='5') System.out.println(i);
				set(x, y, i);
				ans[x][y] = (char) (i + '0');
				dfs(deep + 1);
				if(flag) return ;
				ans[x][y] = '.';
				set(x, y, i);
			}
		}
	}
	void init() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (ans[i][j] != '.')
					set(i, j, ans[i][j] - '0');
			}
		}
	}
	public void solveSudoku(char[][] b) {
		ans = b;
		init();
		dfs(0);
	}
	public static void main(String[] args) {
		String str[] = {".....7..9",".4..812..","...9...1.","..53...72","293....5.",".....53..","8...23...","7...5..4.","531.7...."};
		char[][] b = new char[9][];
		for (int i = 0; i < 9; i++)
			b[i] = str[i].toCharArray();
		SudokuSolver t = new SudokuSolver();
		t.solveSudoku(b);
		t.show();
		
	}
}
