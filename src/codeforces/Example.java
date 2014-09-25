package codeforces;

import java.util.*;

public class Example {

	static int[][] f = new int[101][222222];
	static int[] a = new int[101];
	static int[] b = new int[101];
	static int n, k;

	private static int max(int a, int b) {
		if (a > b)
			return a;
		else
			return b;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		k = input.nextInt();
		for (int i = 1; i <= n; i++)
			a[i] = input.nextInt();
		for (int i = 1; i <= n; i++)
			b[i] = input.nextInt();
		for (int i = 1; i <= n; i++)
			b[i] *= k;
		for (int i = 1; i <= n; i++)
			for (int j = 0; j < 222222; j++)
				f[i][j] = -1;
		f[1][100000] = 0;
		f[1][a[1] - b[1] + 100000] = a[1];
		for (int i = 1; i < n; i++)
			for (int j = 0; j < 222222; j++)
				if (f[i][j] > -1) {
					f[i + 1][j] = max(f[i + 1][j], f[i][j]);
					int p = a[i + 1] - b[i + 1];
					f[i + 1][j + p] = max(f[i + 1][j + p], f[i][j] + a[i + 1]);
				}
		if (f[n][100000] == 0)
			System.out.println(-1);
		else
			System.out.println(f[n][100000]);
		input.close();
	}

}
