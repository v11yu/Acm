package codeforces.div_2_263;

import java.util.Arrays;
import java.util.Scanner;

public class C {
	static int num[] ;
	public static void main(String[] args) {
		int n;
		Scanner cin = new Scanner(System.in);
		n = cin.nextInt();
		num = new int[n];
		for(int i=0;i<n;i++){
			num[i] = cin.nextInt();
		}
		Arrays.sort(num);
		long ans = 0;
		long cnt = 1;
		long nn = 0;
		long one = 1;
		for(int i=0;i<n-1;i++){
			cnt = cnt + one;
			nn = num[i];
			ans = ans + nn*cnt;
		}
		nn = num[n-1];
		ans = ans + nn*cnt;
		System.out.println(ans);
	}
}
