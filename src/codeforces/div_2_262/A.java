package codeforces.div_2_262;

import java.util.Scanner;

public class A {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n,m;
		n = cin.nextInt();
		m = cin.nextInt();
		int res = n;
		while(n/m > 0){
			res += n/m;
			n = n/m + n%m;
		}
		System.out.println(res);
		cin.close();
	}
}
