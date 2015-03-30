package leetcode.unsolve;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import leetcode.model.Point;

public class Test {
	public boolean isValidSudoku(char[][] board) {
		int col[] = new int[9];
		int row[] = new int[9];
		int m[] = new int[9];
		int ipow[] = new int[9];
		ipow[0] = 1;
		for (int i = 1; i < ipow.length; i++)
			ipow[i] = ipow[i - 1] * 2;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] != '.') {
					int num = board[i][j] - '0' - 1;
					int idx = (i / 3 + 1) * (j / 3 + 1) - 1;
					int idx1 = (i/3)*3 +j/3;
					if ((col[i] & ipow[num]) != 0 || (row[j] & ipow[num]) != 0
							|| (m[idx] & ipow[num]) != 0){
						System.out.println(idx+" "+idx1);
						System.out.println(i+" "+j );
						return false;
						
					}
						
					col[i] |= ipow[num];
					row[j] |= ipow[num];
					m[idx] |= ipow[num];
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String str[] = { ".87654321", "2........", "3........", "4........",
				"5........", "6........", "7........", "8........", "9........" };
		char[][] b = new char[9][];
		for (int i = 0; i < 9; i++)
			b[i] = str[i].toCharArray();
		System.out.println(new Test().isValidSudoku(b));

	}
}
