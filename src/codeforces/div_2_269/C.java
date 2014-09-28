package codeforces.div_2_269;

import java.util.Scanner;

public class C {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		long n = cin.nextLong();
		long ans = 0;
		long two = 2;
		long three = 3;
		long res = 0;
		for(int i=0;ans<n;i++){
			ans += two;
			ans += three*i;
			//System.out.println(ans);
			if( n<ans ) break;
			if( (n - ans ) % three == 0)res++;
		}
		System.out.println(res);
	}
}
