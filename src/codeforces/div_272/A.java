package codeforces.div_272;

import java.util.Scanner;

public class A {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		int m = cin.nextInt();
		if(n<m){
			System.out.println(-1);
			return ;
		}
		int res = n%2 + n/2;
		if(res % m == 0) System.out.println(res);
		else System.out.println(res + (m-res%m));
	}
}
