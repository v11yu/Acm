package leetcode.unsolve;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
	public static void get(Object a){
		System.out.println(a);
	}
	public static void main(String[] args) throws Exception {
		File file = new File("C://Users//damao//Desktop//ali-data//output//filter_testing.csv");
		BufferedReader read = new BufferedReader(new FileReader(file));
		
		for(int i=0;i<10;i++){
			String str = read.readLine();
			System.out.println(str);
		}
		read.close();

		
		
	}
}

